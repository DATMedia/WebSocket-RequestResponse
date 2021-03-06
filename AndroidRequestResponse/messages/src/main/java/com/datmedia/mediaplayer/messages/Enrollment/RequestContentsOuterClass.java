// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RequestContents.proto

package com.datmedia.mediaplayer.messages.Enrollment;

public final class RequestContentsOuterClass {
  private RequestContentsOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  /**
   * Protobuf enum {@code com.datmedia.mediaplayer.androidrequestresponse.RequestType}
   */
  public enum RequestType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>InitialRequest = 0;</code>
     */
    InitialRequest(0, 0),
    /**
     * <code>ConfirmationReceipt = 1;</code>
     */
    ConfirmationReceipt(1, 1),
    ;

    /**
     * <code>InitialRequest = 0;</code>
     */
    public static final int InitialRequest_VALUE = 0;
    /**
     * <code>ConfirmationReceipt = 1;</code>
     */
    public static final int ConfirmationReceipt_VALUE = 1;


    public final int getNumber() { return value; }

    public static RequestType valueOf(int value) {
      switch (value) {
        case 0: return InitialRequest;
        case 1: return ConfirmationReceipt;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<RequestType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<RequestType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<RequestType>() {
            public RequestType findValueByNumber(int number) {
              return RequestType.valueOf(number);
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
      return RequestContentsOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    private static final RequestType[] VALUES = values();

    public static RequestType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private RequestType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:com.datmedia.mediaplayer.androidrequestresponse.RequestType)
  }

  public interface RequestContentsOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.datmedia.mediaplayer.androidrequestresponse.RequestContents)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .com.datmedia.mediaplayer.androidrequestresponse.RequestType RequestType = 1;</code>
     */
    boolean hasRequestType();
    /**
     * <code>required .com.datmedia.mediaplayer.androidrequestresponse.RequestType RequestType = 1;</code>
     */
    RequestType getRequestType();

    /**
     * <code>required bytes Data = 2;</code>
     */
    boolean hasData();
    /**
     * <code>required bytes Data = 2;</code>
     */
    com.google.protobuf.ByteString getData();
  }
  /**
   * Protobuf type {@code com.datmedia.mediaplayer.androidrequestresponse.RequestContents}
   */
  public static final class RequestContents extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.datmedia.mediaplayer.androidrequestresponse.RequestContents)
      RequestContentsOrBuilder {
    // Use RequestContents.newBuilder() to construct.
    private RequestContents(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private RequestContents(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final RequestContents defaultInstance;
    public static RequestContents getDefaultInstance() {
      return defaultInstance;
    }

    public RequestContents getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private RequestContents(
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
              RequestType value = RequestType.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                requestType_ = value;
              }
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              data_ = input.readBytes();
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
      return RequestContentsOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RequestContentsOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RequestContents.class, Builder.class);
    }

    public static com.google.protobuf.Parser<RequestContents> PARSER =
        new com.google.protobuf.AbstractParser<RequestContents>() {
      public RequestContents parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new RequestContents(input, extensionRegistry);
      }
    };

    @Override
    public com.google.protobuf.Parser<RequestContents> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int REQUESTTYPE_FIELD_NUMBER = 1;
    private RequestType requestType_;
    /**
     * <code>required .com.datmedia.mediaplayer.androidrequestresponse.RequestType RequestType = 1;</code>
     */
    public boolean hasRequestType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .com.datmedia.mediaplayer.androidrequestresponse.RequestType RequestType = 1;</code>
     */
    public RequestType getRequestType() {
      return requestType_;
    }

    public static final int DATA_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString data_;
    /**
     * <code>required bytes Data = 2;</code>
     */
    public boolean hasData() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes Data = 2;</code>
     */
    public com.google.protobuf.ByteString getData() {
      return data_;
    }

    private void initFields() {
      requestType_ = RequestType.InitialRequest;
      data_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasRequestType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasData()) {
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
        output.writeEnum(1, requestType_.getNumber());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, data_);
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
          .computeEnumSize(1, requestType_.getNumber());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, data_);
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

    public static RequestContents parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RequestContents parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RequestContents parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RequestContents parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RequestContents parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static RequestContents parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static RequestContents parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static RequestContents parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static RequestContents parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static RequestContents parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(RequestContents prototype) {
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
     * Protobuf type {@code com.datmedia.mediaplayer.androidrequestresponse.RequestContents}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.datmedia.mediaplayer.androidrequestresponse.RequestContents)
        RequestContentsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RequestContentsOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RequestContentsOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                RequestContents.class, Builder.class);
      }

      // Construct using com.datmedia.mediaplayer.androidrequestresponse.RequestContentsOuterClass.RequestContents.newBuilder()
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
        requestType_ = RequestType.InitialRequest;
        bitField0_ = (bitField0_ & ~0x00000001);
        data_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RequestContentsOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_descriptor;
      }

      public RequestContents getDefaultInstanceForType() {
        return RequestContents.getDefaultInstance();
      }

      public RequestContents build() {
        RequestContents result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public RequestContents buildPartial() {
        RequestContents result = new RequestContents(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.requestType_ = requestType_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.data_ = data_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof RequestContents) {
          return mergeFrom((RequestContents)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(RequestContents other) {
        if (other == RequestContents.getDefaultInstance()) return this;
        if (other.hasRequestType()) {
          setRequestType(other.getRequestType());
        }
        if (other.hasData()) {
          setData(other.getData());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasRequestType()) {
          
          return false;
        }
        if (!hasData()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        RequestContents parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (RequestContents) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private RequestType requestType_ = RequestType.InitialRequest;
      /**
       * <code>required .com.datmedia.mediaplayer.androidrequestresponse.RequestType RequestType = 1;</code>
       */
      public boolean hasRequestType() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required .com.datmedia.mediaplayer.androidrequestresponse.RequestType RequestType = 1;</code>
       */
      public RequestType getRequestType() {
        return requestType_;
      }
      /**
       * <code>required .com.datmedia.mediaplayer.androidrequestresponse.RequestType RequestType = 1;</code>
       */
      public Builder setRequestType(RequestType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        requestType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required .com.datmedia.mediaplayer.androidrequestresponse.RequestType RequestType = 1;</code>
       */
      public Builder clearRequestType() {
        bitField0_ = (bitField0_ & ~0x00000001);
        requestType_ = RequestType.InitialRequest;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes Data = 2;</code>
       */
      public boolean hasData() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required bytes Data = 2;</code>
       */
      public com.google.protobuf.ByteString getData() {
        return data_;
      }
      /**
       * <code>required bytes Data = 2;</code>
       */
      public Builder setData(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes Data = 2;</code>
       */
      public Builder clearData() {
        bitField0_ = (bitField0_ & ~0x00000002);
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.datmedia.mediaplayer.androidrequestresponse.RequestContents)
    }

    static {
      defaultInstance = new RequestContents(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.datmedia.mediaplayer.androidrequestresponse.RequestContents)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\025RequestContents.proto\022/com.datmedia.me" +
      "diaplayer.androidrequestresponse\"r\n\017Requ" +
      "estContents\022Q\n\013RequestType\030\001 \002(\0162<.com.d" +
      "atmedia.mediaplayer.androidrequestrespon" +
      "se.RequestType\022\014\n\004Data\030\002 \002(\014*:\n\013RequestT" +
      "ype\022\022\n\016InitialRequest\020\000\022\027\n\023ConfirmationR" +
      "eceipt\020\001"
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
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_datmedia_mediaplayer_androidrequestresponse_RequestContents_descriptor,
        new String[] { "RequestType", "Data", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
