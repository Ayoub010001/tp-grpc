// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source:  schema.proto

package org.xproce.lab;

public interface VideoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.xproce.lab.Video)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string title = 2;</code>
   * @return The title.
   */
  java.lang.String getTitle();
  /**
   * <code>string title = 2;</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string description = 3;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 3;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>string url = 4;</code>
   * @return The url.
   */
  java.lang.String getUrl();
  /**
   * <code>string url = 4;</code>
   * @return The bytes for url.
   */
  com.google.protobuf.ByteString
      getUrlBytes();

  /**
   * <code>int32 duration_seconds = 5;</code>
   * @return The durationSeconds.
   */
  int getDurationSeconds();

  /**
   * <code>.org.xproce.lab.Creator creator = 6;</code>
   * @return Whether the creator field is set.
   */
  boolean hasCreator();
  /**
   * <code>.org.xproce.lab.Creator creator = 6;</code>
   * @return The creator.
   */
  org.xproce.lab.Creator getCreator();
  /**
   * <code>.org.xproce.lab.Creator creator = 6;</code>
   */
  org.xproce.lab.CreatorOrBuilder getCreatorOrBuilder();
}