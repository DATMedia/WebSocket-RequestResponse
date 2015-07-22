using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace ServerApplication
{
    [DataContract]
    class PiResponseMessage
    {
        [DataMember]
        public double Result { get; set; }
    }
}
