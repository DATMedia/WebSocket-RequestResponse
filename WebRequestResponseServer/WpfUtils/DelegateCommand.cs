using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace WpfUtils
{
    public sealed class DelegateCommand : ICommand
    {
        public event EventHandler CanExecuteChanged;

        private readonly Action _action;
        public DelegateCommand(Action action)
        {
            _action = action;
        }

        bool ICommand.CanExecute(object parameter)
        {
            return true;
        }

        void ICommand.Execute(object parameter)
        {
            _action();
        }
    }
}
