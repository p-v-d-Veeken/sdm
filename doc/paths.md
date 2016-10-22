
<a name="paths"></a>
## Paths

<a name="clients-post"></a>
### POST /clients

#### Description
Creates a new 'ApiClient' enitity


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||
|**Body**|**client**  <br>*required*||[ApiClient](#apiclient)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-get"></a>
### GET /clients

#### Description
Retrieves an array of all 'ApiClient' entities.
Only permitted by the consultant


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encryption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|< [ApiClient](#apiclient) > array|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-get"></a>
### GET /clients/{clientId}

#### Description
Retrieves a  'ApiClient' entity.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ApiClient](#apiclient)|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-put"></a>
### PUT /clients/{clientId}

#### Description
Updates a  'ApiClient' entity.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**client**  <br>*required*||[ApiClient](#apiclient)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-delete"></a>
### DELETE /clients/{clientId}

#### Description
Deletes a  'ApiClient' entity.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-apirecords-post"></a>
### POST /clients/{clientId}/ApiRecords

#### Description
Creates a new 'ApiRecord' enitity for thr thw owning client


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**client**  <br>*required*||[ApiRecord](#apirecord)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-apirecords-get"></a>
### GET /clients/{clientId}/ApiRecords

#### Description
Retrieves an array of all 'ApiRecord' entities owned by the client indicated with the clientId.
Only permitted by the consultant


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**query**  <br>*required*|The query to filter the ApiRecords with|< [Query](#query) > array||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|< [ApiRecord](#apirecord) > array|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-apirecords-apirecordid-put"></a>
### PUT /clients/{clientId}/ApiRecords/{ApiRecordId}

#### Description
Updates a  'ApiRecord' entity owned by the client.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||
|**Path**|**ApiRecordId**  <br>*required*|The ID of the client|integer||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**client**  <br>*required*||[ApiRecord](#apirecord)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-apirecords-apirecordid-delete"></a>
### DELETE /clients/{clientId}/ApiRecords/{ApiRecordId}

#### Description
Deletes a  'ApiRecord' entity owned by the client.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encruption key type|string||
|**Path**|**ApiRecordId**  <br>*required*|The ID of the client|integer||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|



