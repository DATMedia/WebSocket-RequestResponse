//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from: protoBufferFiles/chatMessage.proto
namespace ServerApplication
{
  [global::System.Serializable, global::ProtoBuf.ProtoContract(Name=@"ChatMessage")]
  public partial class ChatMessage : global::ProtoBuf.IExtensible
  {
    public ChatMessage() {}
    
    private string _Name;
    [global::ProtoBuf.ProtoMember(1, IsRequired = true, Name=@"Name", DataFormat = global::ProtoBuf.DataFormat.Default)]
    public string Name
    {
      get { return _Name; }
      set { _Name = value; }
    }
    private long _DateTime;
    [global::ProtoBuf.ProtoMember(2, IsRequired = true, Name=@"DateTime", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public long DateTime
    {
      get { return _DateTime; }
      set { _DateTime = value; }
    }
    private string _Text;
    [global::ProtoBuf.ProtoMember(3, IsRequired = true, Name=@"Text", DataFormat = global::ProtoBuf.DataFormat.Default)]
    public string Text
    {
      get { return _Text; }
      set { _Text = value; }
    }
    private global::ProtoBuf.IExtension extensionObject;
    global::ProtoBuf.IExtension global::ProtoBuf.IExtensible.GetExtensionObject(bool createIfMissing)
      { return global::ProtoBuf.Extensible.GetExtensionObject(ref extensionObject, createIfMissing); }
  }
  
}