
<a name="paths"></a>
## Paths

<a name="clients-post"></a>
### POST /clients

#### Description
Creates a new 'Client' enitity


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
|**Body**|**client**  <br>*required*||[ApiClient](#apiclient)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ApiClient](#apiclient)|
|**400**|Something went wrong|No Content|


<a name="clients-get"></a>
### GET /clients

#### Description
Retrieves an array of all 'Client' entities.
Only permitted by the consultant


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|< [ApiClient](#apiclient) > array|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-get"></a>
### GET /clients/{clientId}

#### Description
Retrieves a  'Client' entity.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ApiClient](#apiclient)|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-put"></a>
### PUT /clients/{clientId}

#### Description
Updates a  'Client' entity.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
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
Deletes a  'Client' entity.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-records-post"></a>
### POST /clients/{clientId}/records

#### Description
Creates a new 'Record' enitity for the owning client


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**record**  <br>*required*||[ApiRecord](#apirecord)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ApiRecord](#apirecord)|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-records-get"></a>
### GET /clients/{clientId}/records

#### Description
Retrieves an array of all 'Record' entities owned by the client indicated with the clientId.
Only permitted by the consultant


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|< [ApiRecord](#apirecord) > array|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-records-recordid-get"></a>
### GET /clients/{clientId}/records/{recordId}

#### Description
Retrieves a  'Record' entity owned by the client.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Path**|**recordId**  <br>*required*|The ID of the client|integer||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ApiRecord](#apirecord)|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-records-recordid-put"></a>
### PUT /clients/{clientId}/records/{recordId}

#### Description
Updates a  'Record' entity owned by the client.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Path**|**recordId**  <br>*required*|The ID of the client|integer||
|**Body**|**record**  <br>*required*||[ApiRecord](#apirecord)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-records-recordid-delete"></a>
### DELETE /clients/{clientId}/records/{recordId}

#### Description
Deletes a  'Record' entity owned by the client.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**x-key**  <br>*required*|The encruption key|string||
|**Header**|**x-key-type**  <br>*required*|The encryption key type|string||
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Path**|**recordId**  <br>*required*|The ID of the client|integer||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|



