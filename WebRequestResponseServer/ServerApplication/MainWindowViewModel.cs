using System;
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

namespace ServerApplication
{
    class MainWindowViewModel : INotifyPropertyChanged, IInterceptor
    {
        private readonly Dispatcher _dispatcher = Dispatcher.CurrentDispatcher;
        private static readonly ProxyGenerator _proxyGenerator = new ProxyGenerator();

        public event PropertyChangedEventHandler PropertyChanged;


        private IDuplexTypedMessagesFactory CreateReceiverFactory()
        {
            ISerializer jsonSerializer = new DataContractJsonStringSerializer();
            ISerializer wrappingSerializer = _proxyGenerator.CreateInterfaceProxyWithTarget<ISerializer>(jsonSerializer, this);


            return new DuplexTypedMessagesFactory(wrappingSerializer);
        }

        private readonly Lazy<IDuplexTypedMessagesFactory> _receiverFactory;

        public MainWindowViewModel()
        {
            _receiverFactory = new Lazy<IDuplexTypedMessagesFactory>(CreateReceiverFactory);
        }
        private IDuplexTypedMessageReceiver<PiResponseMessage, PiRequestMessage> _receiver = null;

        public void OpenServer()
        {


            _receiver = _receiverFactory.Value.CreateDuplexTypedMessageReceiver<PiResponseMessage, PiRequestMessage>();
            _receiver.MessageReceived += OnMessageReceived;

            _receiver.ResponseReceiverConnected += OnClientConnected;
            _receiver.ResponseReceiverDisconnected += OnClientDisconnected;

            // Use webSocket for the communication
            IMessagingSystemFactory messaging = new WebSocketMessagingSystemFactory();

            // Attach input channel and be able to receive request messages and send back response messages.
            IDuplexInputChannel inputChannel = messaging.CreateDuplexInputChannel("ws://127.0.0.1:8091/PiCalculator/");
            _receiver.AttachDuplexInputChannel(inputChannel);

        }

        public void CloseServer()
        {
            if (_receiver != null)
            {
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

        private void OnMessageReceived(object sender, TypedRequestReceivedEventArgs<PiRequestMessage> e)
        {
            if (e.ReceivingError != null)
            {
                LogMessage(e.ReceivingError.Message);
                return;
            }
        
            LogMessage(String.Format("OnMessageReceived: ResponseReceiverId = {0}, SenderAddress = {1}, CalculationStep={2}", e.ResponseReceiverId, e.SenderAddress, e.RequestMessage?.CalculationStep)); ;
            // Get the receiver instance.
            IDuplexTypedMessageReceiver<PiResponseMessage, PiRequestMessage> aReceiver = (IDuplexTypedMessageReceiver<PiResponseMessage, PiRequestMessage>)sender;

            PiResponseMessage aResponseMessage = new PiResponseMessage();

            // Calculate PI and send back multiple response messages.
            double aResult = 0.0;
            double aDx = e.RequestMessage.CalculationStep;
            for (double x = -1.0; x < 1.0; x += aDx)
            {
                aResult += 2 * Math.Sqrt(1 - x * x) * aDx;

                // Send back the current result.
                // Note: ResponseReceiverId identifies the client who sent the request.
                aResponseMessage.Result = aResult;
                aReceiver.SendResponseMessage(e.ResponseReceiverId, aResponseMessage);
                System.Threading.Thread.Sleep(100);
            }

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
