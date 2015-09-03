// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: InitialResponse.proto

package com.datmedia.mediaplayer.messages.Enrollment;

public final class InitialResponseOuterClass {
  private InitialResponseOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface InitialResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.datmedia.mediaplayer.androidrequestresponse.InitialResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string UniqueEnrollmentCode = 1;</code>
     */
    boolean hasUniqueEnrollmentCode();
    /**
     * <code>required string UniqueEnrollmentCode = 1;</code>
     */
    String getUniqueEnrollmentCode();
    /**
     * <code>required string UniqueEnrollmentCode = 1;</code>
     */
    com.google.protobuf.ByteString
        getUniqueEnrollmentCodeBytes();

    /**
     * <code>required bytes ServerPublicKey = 2;</code>
     */
    boolean hasServerPublicKey();
    /**
     * <code>required bytes ServerPublicKey = 2;</code>
     */
    com.google.protobuf.ByteString getServerPublicKey();
  }
  /**
   * Protobuf type {@code com.datmedia.mediaplayer.androidrequestresponse.InitialResponse}
   */
  public static final class InitialResponse extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.datmedia.mediaplayer.androidrequestresponse.InitialResponse)
      InitialResponseOrBuilder {
    // Use InitialResponse.newBuilder() to construct.
    private InitialResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private InitialResponse(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final InitialResponse defaultInstance;
    public static InitialResponse getDefaultInstance() {
      return defaultInstance;
    }

    public InitialResponse getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private InitialResponse(
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
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              uniqueEnrollmentCode_ = bs;
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              serverPublicKey_ = input.readBytes();
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
      return InitialResponseOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return InitialResponseOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              InitialResponse.class, Builder.class);
    }

    public static com.google.protobuf.Parser<InitialResponse> PARSER =
        new com.google.protobuf.AbstractParser<InitialResponse>() {
      public InitialResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new InitialResponse(input, extensionRegistry);
      }
    };

    @Override
    public com.google.protobuf.Parser<InitialResponse> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int UNIQUEENROLLMENTCODE_FIELD_NUMBER = 1;
    private Object uniqueEnrollmentCode_;
    /**
     * <code>required string UniqueEnrollmentCode = 1;</code>
     */
    public boolean hasUniqueEnrollmentCode() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string UniqueEnrollmentCode = 1;</code>
     */
    public String getUniqueEnrollmentCode() {
      Object ref = uniqueEnrollmentCode_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          uniqueEnrollmentCode_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string UniqueEnrollmentCode = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUniqueEnrollmentCodeBytes() {
      Object ref = uniqueEnrollmentCode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        uniqueEnrollmentCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SERVERPUBLICKEY_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString serverPublicKey_;
    /**
     * <code>required bytes ServerPublicKey = 2;</code>
     */
    public boolean hasServerPublicKey() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes ServerPublicKey = 2;</code>
     */
    public com.google.protobuf.ByteString getServerPublicKey() {
      return serverPublicKey_;
    }

    private void initFields() {
      uniqueEnrollmentCode_ = "";
      serverPublicKey_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasUniqueEnrollmentCode()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasServerPublicKey()) {
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
        output.writeBytes(1, getUniqueEnrollmentCodeBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, serverPublicKey_);
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
          .computeBytesSize(1, getUniqueEnrollmentCodeBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, serverPublicKey_);
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

    public static InitialResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static InitialResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static InitialResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static InitialResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static InitialResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static InitialResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static InitialResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static InitialResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static InitialResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static InitialResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(InitialResponse prototype) {
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
     * Protobuf type {@code com.datmedia.mediaplayer.androidrequestresponse.InitialResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.datmedia.mediaplayer.androidrequestresponse.InitialResponse)
        InitialResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return InitialResponseOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return InitialResponseOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                InitialResponse.class, Builder.class);
      }

      // Construct using com.datmedia.mediaplayer.androidrequestresponse.InitialResponseOuterClass.InitialResponse.newBuilder()
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
        uniqueEnrollmentCode_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        serverPublicKey_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return InitialResponseOuterClass.internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_descriptor;
      }

      public InitialResponse getDefaultInstanceForType() {
        return InitialResponse.getDefaultInstance();
      }

      public InitialResponse build() {
        InitialResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public InitialResponse buildPartial() {
        InitialResponse result = new InitialResponse(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.uniqueEnrollmentCode_ = uniqueEnrollmentCode_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.serverPublicKey_ = serverPublicKey_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof InitialResponse) {
          return mergeFrom((InitialResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(InitialResponse other) {
        if (other == InitialResponse.getDefaultInstance()) return this;
        if (other.hasUniqueEnrollmentCode()) {
          bitField0_ |= 0x00000001;
          uniqueEnrollmentCode_ = other.uniqueEnrollmentCode_;
          onChanged();
        }
        if (other.hasServerPublicKey()) {
          setServerPublicKey(other.getServerPublicKey());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasUniqueEnrollmentCode()) {
          
          return false;
        }
        if (!hasServerPublicKey()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        InitialResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (InitialResponse) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private Object uniqueEnrollmentCode_ = "";
      /**
       * <code>required string UniqueEnrollmentCode = 1;</code>
       */
      public boolean hasUniqueEnrollmentCode() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string UniqueEnrollmentCode = 1;</code>
       */
      public String getUniqueEnrollmentCode() {
        Object ref = uniqueEnrollmentCode_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            uniqueEnrollmentCode_ = s;
          }
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>required string UniqueEnrollmentCode = 1;</code>
       */
      public com.google.protobuf.ByteString
          getUniqueEnrollmentCodeBytes() {
        Object ref = uniqueEnrollmentCode_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          uniqueEnrollmentCode_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string UniqueEnrollmentCode = 1;</code>
       */
      public Builder setUniqueEnrollmentCode(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        uniqueEnrollmentCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string UniqueEnrollmentCode = 1;</code>
       */
      public Builder clearUniqueEnrollmentCode() {
        bitField0_ = (bitField0_ & ~0x00000001);
        uniqueEnrollmentCode_ = getDefaultInstance().getUniqueEnrollmentCode();
        onChanged();
        return this;
      }
      /**
       * <code>required string UniqueEnrollmentCode = 1;</code>
       */
      public Builder setUniqueEnrollmentCodeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        uniqueEnrollmentCode_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString serverPublicKey_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes ServerPublicKey = 2;</code>
       */
      public boolean hasServerPublicKey() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required bytes ServerPublicKey = 2;</code>
       */
      public com.google.protobuf.ByteString getServerPublicKey() {
        return serverPublicKey_;
      }
      /**
       * <code>required bytes ServerPublicKey = 2;</code>
       */
      public Builder setServerPublicKey(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        serverPublicKey_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes ServerPublicKey = 2;</code>
       */
      public Builder clearServerPublicKey() {
        bitField0_ = (bitField0_ & ~0x00000002);
        serverPublicKey_ = getDefaultInstance().getServerPublicKey();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.datmedia.mediaplayer.androidrequestresponse.InitialResponse)
    }

    static {
      defaultInstance = new InitialResponse(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.datmedia.mediaplayer.androidrequestresponse.InitialResponse)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\025InitialResponse.proto\022/com.datmedia.me" +
      "diaplayer.androidrequestresponse\"H\n\017Init" +
      "ialResponse\022\034\n\024UniqueEnrollmentCode\030\001 \002(" +
      "\t\022\027\n\017ServerPublicKey\030\002 \002(\014"
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
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_datmedia_mediaplayer_androidrequestresponse_InitialResponse_descriptor,
        new String[] { "UniqueEnrollmentCode", "ServerPublicKey", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}