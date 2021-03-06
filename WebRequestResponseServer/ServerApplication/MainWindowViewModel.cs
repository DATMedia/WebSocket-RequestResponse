﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Eneter.Messaging.DataProcessing.Serializing;
using Eneter.Messaging.EndPoints.TypedMessages;
using Eneter.Messaging.MessagingSystems.MessagingSystemBase;
using Eneter.Messaging.MessagingSystems.WebSocketMessagingSystem;
using System.Windows.Input;
using WpfUtils;
using System.Windows.Threading;
using System.Collections.ObjectModel;
using Castle.DynamicProxy;
using Eneter.ProtoBuf;

namespace ServerApplication
{
    class MainWindowViewModel : INotifyPropertyChanged, IInterceptor
    {
        private readonly Dispatcher _dispatcher = Dispatcher.CurrentDispatcher;
        private static readonly ProxyGenerator _proxyGenerator = new ProxyGenerator();

        public event PropertyChangedEventHandler PropertyChanged;

        protected void OnPropertyChanged(string propertyName)
        {
            if (this.PropertyChanged != null)
            {
                this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        private bool _isOpen;
        private bool _isClose;
        public bool IsOpen { get { return _isOpen; } set { _isOpen = value; OnPropertyChanged("IsOpen"); } }

        public bool IsClose { get { return _isClose; } set { _isClose = value; OnPropertyChanged("IsClose"); } }

        private IDuplexTypedMessagesFactory CreateReceiverFactory()
        {
            ISerializer protoBufSerializer = new ProtoBufSerializer();
           
           // ISerializer wrappingSerializer = _proxyGenerator.CreateInterfaceProxyWithTarget<ISerializer>(jsonSerializer, this);


            return new DuplexTypedMessagesFactory(protoBufSerializer);
        }

        private readonly Lazy<IDuplexTypedMessagesFactory> _receiverFactory;

        public MainWindowViewModel()
        {
            _receiverFactory = new Lazy<IDuplexTypedMessagesFactory>(CreateReceiverFactory);
            IsOpen = true;
            IsClose = false;
        }
        private IDuplexTypedMessageReceiver<ChatMessage, ChatMessage> _receiver = null;

        public void OpenServer()
        {
            IsClose = true;
            IsOpen = false;
            _receiver = _receiverFactory.Value.CreateDuplexTypedMessageReceiver<ChatMessage, ChatMessage>();
            _receiver.MessageReceived += OnMessageReceived;

            _receiver.ResponseReceiverConnected += OnClientConnected;
            _receiver.ResponseReceiverDisconnected += OnClientDisconnected;

            // Use webSocket for the communication
            IMessagingSystemFactory messaging = new WebSocketMessagingSystemFactory();

            // Attach input channel and be able to receive request messages and send back response messages.
            IDuplexInputChannel inputChannel = messaging.CreateDuplexInputChannel("ws://192.168.15.124:8091/");
            _receiver.AttachDuplexInputChannel(inputChannel);

        }

        public void CloseServer()
        {
            if (_receiver != null)
            {
                IsClose = false;
                IsOpen = true;
                _receiver.DetachDuplexInputChannel();
                _receiver = null;
            }
        }

        private readonly ObservableCollection<string> _logMessages = new ObservableCollection<string>();


        public ObservableCollection<string> LogMessages
        {
            get
            {
                return _logMessages;
            }
        }
    
        public void LogMessage(string message)
        {
            string fullMessage = String.Format("{0}: {1}", DateTime.Now.ToString("HH:mm.fff"), message);
            _dispatcher.BeginInvoke(new Action(() =>
            {
                _logMessages.Add(fullMessage);
            }));

        }

        private void OnClientDisconnected(object sender, ResponseReceiverEventArgs e)
        {
            LogMessage(String.Format("OnClientDisconnected: ResponseReceiverId = {0}, SenderAddress = {1}", e.ResponseReceiverId, e.SenderAddress));
        }

        private void OnClientConnected(object sender, ResponseReceiverEventArgs e)
        {
            LogMessage(String.Format("OnClientConnected: ResponseReceiverId = {0}, SenderAddress = {1}", e.ResponseReceiverId, e.SenderAddress));
        }

        private void OnMessageReceived(object sender, TypedRequestReceivedEventArgs<ChatMessage> e)
        {
            if (e.ReceivingError != null)
            {
                LogMessage(e.ReceivingError.Message);
                return;
            }
        
           // LogMessage(String.Format("OnMessageReceived: ResponseReceiverId = {0}, SenderAddress = {1}, CalculationStep={2}", e.ResponseReceiverId, e.SenderAddress, e.RequestMessage?.CalculationStep)); ;
            // Get the receiver instance.
            IDuplexTypedMessageReceiver<ChatMessage, ChatMessage> aReceiver = (IDuplexTypedMessageReceiver<ChatMessage, ChatMessage>)sender;

            ChatMessage aResponseMessage = new ChatMessage();

            //// Calculate PI and send back multiple response messages.
            //double aResult = 0.0;
            //double aDx = e.RequestMessage.CalculationStep;
            //for (double x = -1.0; x < 1.0; x += aDx)
            //{
            //    aResult += 2 * Math.Sqrt(1 - x * x) * aDx;

            //    // Send back the current result.
            //    // Note: ResponseReceiverId identifies the client who sent the request.
            //    aResponseMessage.Result = aResult;
            //    aReceiver.SendResponseMessage(e.ResponseReceiverId, aResponseMessage);
            //    System.Threading.Thread.Sleep(100);
            //}

            aResponseMessage.Name = "Hi " + e.RequestMessage.Name;
            aResponseMessage.Text = "";
            aResponseMessage.DateTime = 100;
            aReceiver.SendResponseMessage(e.ResponseReceiverId, aResponseMessage);

        }

        void IInterceptor.Intercept(IInvocation invocation)
        {
            LogMessage(String.Format("Method {0} invoked", invocation.Method.Name));
            invocation.Proceed();

        }

        public ICommand OpenServerCommand
        {
            get { return new DelegateCommand(() => this.OpenServer()); }
        }

        public ICommand CloseServerCommand
        {
            get { return new DelegateCommand(() => this.CloseServer()); }
        }
    
    
    }
}
