/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.logging.v2;

import static com.google.logging.v2.ConfigServiceV2Client.ListBucketsPagedResponse;
import static com.google.logging.v2.ConfigServiceV2Client.ListExclusionsPagedResponse;
import static com.google.logging.v2.ConfigServiceV2Client.ListSinksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ConfigServiceV2ClientTest {
  private static MockServiceHelper mockServiceHelper;
  private ConfigServiceV2Client client;
  private LocalChannelProvider channelProvider;
  private static MockConfigServiceV2 mockConfigServiceV2;

  @BeforeClass
  public static void startStaticServer() {
    mockConfigServiceV2 = new MockConfigServiceV2();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockConfigServiceV2));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    ConfigServiceV2Settings settings =
        ConfigServiceV2Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigServiceV2Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listBucketsTest() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountLocationName parent =
        BillingAccountLocationName.of("[BILLING_ACCOUNT]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountLocationName parent =
          BillingAccountLocationName.of("[BILLING_ACCOUNT]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest2() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest3() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest4() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest5() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBucketTest() throws Exception {
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetentionDays(1544391896)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    GetBucketRequest request =
        GetBucketRequest.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .build();

    LogBucket actualResponse = client.getBucket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBucketRequest actualRequest = ((GetBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      GetBucketRequest request =
          GetBucketRequest.newBuilder()
              .setName(
                  LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                      .toString())
              .build();
      client.getBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBucketTest() throws Exception {
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetentionDays(1544391896)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    UpdateBucketRequest request =
        UpdateBucketRequest.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setBucket(LogBucket.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    LogBucket actualResponse = client.updateBucket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBucketRequest actualRequest = ((UpdateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getBucket(), actualRequest.getBucket());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      UpdateBucketRequest request =
          UpdateBucketRequest.newBuilder()
              .setName(
                  LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                      .toString())
              .setBucket(LogBucket.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest2() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest3() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest4() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest5() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSinkTest() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");

    LogSink actualResponse = client.getSink(sinkName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSinkRequest actualRequest = ((GetSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName.toString(), actualRequest.getSinkName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      client.getSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSinkTest2() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String sinkName = "sink_name-1391757129";

    LogSink actualResponse = client.getSink(sinkName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSinkRequest actualRequest = ((GetSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName, actualRequest.getSinkName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String sinkName = "sink_name-1391757129";
      client.getSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest2() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest3() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest4() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest5() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSinkTest() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = ((UpdateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName.toString(), actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      LogSink sink = LogSink.newBuilder().build();
      client.updateSink(sinkName, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSinkTest2() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String sinkName = "sink_name-1391757129";
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = ((UpdateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName, actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String sinkName = "sink_name-1391757129";
      LogSink sink = LogSink.newBuilder().build();
      client.updateSink(sinkName, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSinkTest3() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    LogSink sink = LogSink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = ((UpdateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName.toString(), actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSinkExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      LogSink sink = LogSink.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSink(sinkName, sink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSinkTest4() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .setWriterIdentity("writer_identity775638794")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String sinkName = "sink_name-1391757129";
    LogSink sink = LogSink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = ((UpdateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName, actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSinkExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String sinkName = "sink_name-1391757129";
      LogSink sink = LogSink.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSink(sinkName, sink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");

    client.deleteSink(sinkName);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSinkRequest actualRequest = ((DeleteSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName.toString(), actualRequest.getSinkName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      client.deleteSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String sinkName = "sink_name-1391757129";

    client.deleteSink(sinkName);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSinkRequest actualRequest = ((DeleteSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName, actualRequest.getSinkName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String sinkName = "sink_name-1391757129";
      client.deleteSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest2() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest3() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest4() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest5() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExclusionTest() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");

    LogExclusion actualResponse = client.getExclusion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExclusionRequest actualRequest = ((GetExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
      client.getExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExclusionTest2() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";

    LogExclusion actualResponse = client.getExclusion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExclusionRequest actualRequest = ((GetExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExclusionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      client.getExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest2() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest3() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest4() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest5() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExclusionTest() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogExclusion actualResponse = client.updateExclusion(name, exclusion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExclusionRequest actualRequest = ((UpdateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExclusion(name, exclusion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExclusionTest2() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";
    LogExclusion exclusion = LogExclusion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogExclusion actualResponse = client.updateExclusion(name, exclusion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExclusionRequest actualRequest = ((UpdateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExclusionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExclusion(name, exclusion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExclusionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");

    client.deleteExclusion(name);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExclusionRequest actualRequest = ((DeleteExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
      client.deleteExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExclusionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteExclusion(name);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExclusionRequest actualRequest = ((DeleteExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExclusionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCmekSettingsTest() throws Exception {
    CmekSettings expectedResponse =
        CmekSettings.newBuilder()
            .setName(CmekSettingsName.ofProjectName("[PROJECT]").toString())
            .setKmsKeyName("kms_key_name2094986649")
            .setServiceAccountId("service_account_id-111486921")
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    GetCmekSettingsRequest request =
        GetCmekSettingsRequest.newBuilder()
            .setName(CmekSettingsName.ofProjectName("[PROJECT]").toString())
            .build();

    CmekSettings actualResponse = client.getCmekSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCmekSettingsRequest actualRequest = ((GetCmekSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCmekSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      GetCmekSettingsRequest request =
          GetCmekSettingsRequest.newBuilder()
              .setName(CmekSettingsName.ofProjectName("[PROJECT]").toString())
              .build();
      client.getCmekSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCmekSettingsTest() throws Exception {
    CmekSettings expectedResponse =
        CmekSettings.newBuilder()
            .setName(CmekSettingsName.ofProjectName("[PROJECT]").toString())
            .setKmsKeyName("kms_key_name2094986649")
            .setServiceAccountId("service_account_id-111486921")
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    UpdateCmekSettingsRequest request =
        UpdateCmekSettingsRequest.newBuilder()
            .setName("name3373707")
            .setCmekSettings(CmekSettings.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    CmekSettings actualResponse = client.updateCmekSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCmekSettingsRequest actualRequest = ((UpdateCmekSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getCmekSettings(), actualRequest.getCmekSettings());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCmekSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      UpdateCmekSettingsRequest request =
          UpdateCmekSettingsRequest.newBuilder()
              .setName("name3373707")
              .setCmekSettings(CmekSettings.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateCmekSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
