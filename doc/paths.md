
<a name="paths"></a>
## Paths

<a name="clients-post"></a>
### POST /clients

#### Description
Creates a new 'Client' enitity


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Body**|**data**  <br>*required*||[ClientBundle](#clientbundle)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ClientBundle](#clientbundle)|
|**400**|Something went wrong|No Content|


<a name="clients-get"></a>
### GET /clients

#### Description
Retrieves an array of all 'Client' entities.
Only permitted by the consultant


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Body**|**keyring**  <br>*required*||[Keyring](#keyring)||


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
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**keyring**  <br>*required*||[Keyring](#keyring)||


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
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**data**  <br>*required*||[ClientBundle](#clientbundle)||


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
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**keyring**  <br>*required*||[Keyring](#keyring)||


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
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**data**  <br>*required*||[RecordBundle](#recordbundle)||


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
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**data**  <br>*required*||[QueryBundle](#querybundle)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|< [ApiRecord](#apirecord) > array|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-records-recordid-put"></a>
### PUT /clients/{clientId}/records/{recordId}

#### Description
Updates a  'Record' entity owned by the client.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Path**|**recordId**  <br>*required*|The ID of the client|integer||
|**Body**|**data**  <br>*required*||[RecordBundle](#recordbundle)||


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
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Path**|**recordId**  <br>*required*|The ID of the client|integer||
|**Body**|**keyring**  <br>*required*||[Keyring](#keyring)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="keyring-post"></a>
### POST /keyring

#### Description
Call master keyring will be encrypted and stored on the server


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Body**|**keyring**  <br>*required*||[Keyring](#keyring)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


#### Consumes

* `application/zip`


<a name="keyring-retrieve-1-get"></a>
### GET /keyring/retrieve/1

#### Description
Call the master keyring retrieval method (step 1)


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Body**|**answer**  <br>*required*||[ApiRetrievalAnswer](#apiretrievalanswer)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ApiRetrievalResponse](#apiretrievalresponse)|
|**400**|Something went wrong|No Content|


<a name="keyring-retrieve-2-get"></a>
### GET /keyring/retrieve/2

#### Description
Call the master keyring retrieval method (step 2)


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Body**|**answer**  <br>*required*||[ApiRetrievalResponse](#apiretrievalresponse)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ApiRetrievalAnswer](#apiretrievalanswer)|
|**400**|Something went wrong|No Content|


<a name="keyring-retrieve-3-get"></a>
### GET /keyring/retrieve/3

#### Description
Call the master keyring retrieval method (step 3)


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**answer**  <br>*required*|Answer to the current step|string||
|**Query**|**previous**  <br>*required*|The hashed answer to the previous step|string||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[Keyring](#keyring)|
|**400**|Something went wrong|No Content|


#### Produces

* `application/zip`



