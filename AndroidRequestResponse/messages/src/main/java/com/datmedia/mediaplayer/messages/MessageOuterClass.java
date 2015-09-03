// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

package com.datmedia.mediaplayer.messages;

public final class MessageOuterClass {
  private MessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  /**
   * Protobuf enum {@code com.datmedia.mediaplayer.androidrequestresponse.MessageType}
   */
  public enum MessageType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>EnrollmentRequest = 1;</code>
     */
    EnrollmentRequest(0, 1),
    /**
     * <code>EnrollmentResponse = 2;</code>
     */
    EnrollmentResponse(1, 2),
    ;

    /**
     * <code>EnrollmentRequest = 1;</code>
     */
    public static final int EnrollmentRequest_VALUE = 1;
    /**
     * <code>EnrollmentResponse = 2;</code>
     */
    public static final int EnrollmentResponse_VALUE = 2;


    public final int getNumber() { return value; }

    public static MessageType valueOf(int value) {
      switch (value) {
        case 1: return EnrollmentRequest;
        case 2: return EnrollmentResponse;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<MessageType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<MessageType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<MessageType>() {
            public MessageType findValueByNumber(int number) {
              return MessageType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return MessageOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    private static final MessageType[] VALUES = values();

    public static MessageType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private MessageType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:com.datmedia.mediaplayer.androidrequestresponse.MessageType)
  }

  public interface MessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.datmedia.mediaplayer.androidrequestresponse.Message)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .com.datmedia.mediaplayer.androidrequestresponse.MessageType MessageType = 1;</code>
     */
    boolean hasMessageType();
    /**
     * <code>required .com.datmedia.mediaplayer.androidrequestresponse.MessageType MessageType = 1;</code>
     */
    MessageType getMessageType();

    /**
     * <code>required bytes MessageContents = 2;</code>
     */
    boolean hasMessageContents();
    /**
     * <code>required bytes MessageContents = 2;</code>
     */
    com.google.protobuf.ByteString getMessageContents();
  }
  /**
   * Protobuf type {@code com.datmedia.mediaplayer.androidrequestresponse.Message}
   */
  public static final class Message extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.datmedia.mediaplayer.androidrequestresponse.Message)
      MessageOrBuilder {
    // Use Message.newBuilder() to construct.
    private Message(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Message(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Message defaultInstance;
    public static Message getDefaultInstance() {
      return defaultInstance;
    }

    public Message getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Message(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              int rawValue = input.readEnum();
              MessageType value = MessageType.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                messageType_ = value;
              }
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              messageContents_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MessageOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MessageOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Message.class, Builder.class);
    }

    public static com.google.protobuf.Parser<Message> PARSER =
        new com.google.protobuf.AbstractParser<Message>() {
      public Message parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Message(input, extensionRegistry);
      }
    };

    @Override
    public com.google.protobuf.Parser<Message> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int MESSAGETYPE_FIELD_NUMBER = 1;
    private MessageType messageType_;
    /**
     * <code>required .com.datmedia.mediaplayer.androidrequestresponse.MessageType MessageType = 1;</code>
     */
    public boolean hasMessageType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .com.datmedia.mediaplayer.androidrequestresponse.MessageType MessageType = 1;</code>
     */
    public MessageType getMessageType() {
      return messageType_;
    }

    public static final int MESSAGECONTENTS_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString messageContents_;
    /**
     * <code>required bytes MessageContents = 2;</code>
     */
    public boolean hasMessageContents() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes MessageContents = 2;</code>
     */
    public com.google.protobuf.ByteString getMessageContents() {
      return messageContents_;
    }

    private void initFields() {
      messageType_ = MessageType.EnrollmentRequest;
      messageContents_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasMessageType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMessageContents()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, messageType_.getNumber());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, messageContents_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, messageType_.getNumber());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, messageContents_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    protected Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static Message parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Message parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Message parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Message parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Message parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Message parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Message prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.datmedia.mediaplayer.androidrequestresponse.Message}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.datmedia.mediaplayer.androidrequestresponse.Message)
        MessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MessageOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MessageOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Message.class, Builder.class);
      }

      // Construct using com.datmedia.mediaplayer.androidrequestresponse.MessageOuterClass.Message.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        messageType_ = MessageType.EnrollmentRequest;
        bitField0_ = (bitField0_ & ~0x00000001);
        messageContents_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MessageOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_descriptor;
      }

      public Message getDefaultInstanceForType() {
        return Message.getDefaultInstance();
      }

      public Message build() {
        Message result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Message buildPartial() {
        Message result = new Message(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.messageType_ = messageType_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.messageContents_ = messageContents_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Message) {
          return mergeFrom((Message)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Message other) {
        if (other == Message.getDefaultInstance()) return this;
        if (other.hasMessageType()) {
          setMessageType(other.getMessageType());
        }
        if (other.hasMessageContents()) {
          setMessageContents(other.getMessageContents());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasMessageType()) {
          
          return false;
        }
        if (!hasMessageContents()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Message parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Message) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private MessageType messageType_ = MessageType.EnrollmentRequest;
      /**
       * <code>required .com.datmedia.mediaplayer.androidrequestresponse.MessageType MessageType = 1;</code>
       */
      public boolean hasMessageType() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required .com.datmedia.mediaplayer.androidrequestresponse.MessageType MessageType = 1;</code>
       */
      public MessageType getMessageType() {
        return messageType_;
      }
      /**
       * <code>required .com.datmedia.mediaplayer.androidrequestresponse.MessageType MessageType = 1;</code>
       */
      public Builder setMessageType(MessageType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        messageType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required .com.datmedia.mediaplayer.androidrequestresponse.MessageType MessageType = 1;</code>
       */
      public Builder clearMessageType() {
        bitField0_ = (bitField0_ & ~0x00000001);
        messageType_ = MessageType.EnrollmentRequest;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString messageContents_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes MessageContents = 2;</code>
       */
      public boolean hasMessageContents() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required bytes MessageContents = 2;</code>
       */
      public com.google.protobuf.ByteString getMessageContents() {
        return messageContents_;
      }
      /**
       * <code>required bytes MessageContents = 2;</code>
       */
      public Builder setMessageContents(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        messageContents_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes MessageContents = 2;</code>
       */
      public Builder clearMessageContents() {
        bitField0_ = (bitField0_ & ~0x00000002);
        messageContents_ = getDefaultInstance().getMessageContents();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.datmedia.mediaplayer.androidrequestresponse.Message)
    }

    static {
      defaultInstance = new Message(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.datmedia.mediaplayer.androidrequestresponse.Message)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rMessage.proto\022/com.datmedia.mediaplaye" +
      "r.androidrequestresponse\"u\n\007Message\022Q\n\013M" +
      "essageType\030\001 \002(\0162<.com.datmedia.mediapla" +
      "yer.androidrequestresponse.MessageType\022\027" +
      "\n\017MessageContents\030\002 \002(\014*<\n\013MessageType\022\025" +
      "\n\021EnrollmentRequest\020\001\022\026\n\022EnrollmentRespo" +
      "nse\020\002"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_datmedia_mediaplayer_androidrequestresponse_Message_descriptor,
        new String[] { "MessageType", "MessageContents", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
