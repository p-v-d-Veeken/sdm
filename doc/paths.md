
<a name="paths"></a>
## Paths

<a name="clients-get-post"></a>
### POST /clients/get

#### Description
Retrieves an array of all 'Client' entities.
Only permitted by the consultant


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Body**|**keyringData**  <br>*required*||[KeyringData](#keyringdata)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|< [ApiClient](#apiclient) > array|
|**400**|Something went wrong|No Content|


<a name="clients-post-post"></a>
### POST /clients/post

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


<a name="clients-clientid-delete-post"></a>
### POST /clients/{clientId}/delete

#### Description
Deletes a  'Client' entity.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**keyringData**  <br>*required*||[KeyringData](#keyringdata)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-get-post"></a>
### POST /clients/{clientId}/get

#### Description
Retrieves a  'Client' entity.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Body**|**keyringData**  <br>*required*||[KeyringData](#keyringdata)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|[ApiClient](#apiclient)|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-put-post"></a>
### POST /clients/{clientId}/put

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


<a name="clients-clientid-records-get-post"></a>
### POST /clients/{clientId}/records/get

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


<a name="clients-clientid-records-post-post"></a>
### POST /clients/{clientId}/records/post

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


<a name="clients-clientid-records-recordid-delete-post"></a>
### POST /clients/{clientId}/records/{recordId}/delete

#### Description
Deletes a  'Record' entity owned by the client.
Only permitted by the consultant or the client itself


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**clientId**  <br>*required*|The ID of the client|integer||
|**Path**|**recordId**  <br>*required*|The ID of the client|integer||
|**Body**|**keyringData**  <br>*required*||[KeyringData](#keyringdata)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


<a name="clients-clientid-records-recordid-put-post"></a>
### POST /clients/{clientId}/records/{recordId}/put

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


<a name="keyring-post-post"></a>
### POST /keyring/post

#### Description
Call master keyring will be encrypted and stored on the server


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Body**|**keyringData**  <br>*required*||[KeyringData](#keyringdata)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|Successful response|No Content|
|**400**|Something went wrong|No Content|


#### Consumes

* `application/zip`


<a name="keyring-retrieve-1-get-post"></a>
### POST /keyring/retrieve/1/get

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


<a name="keyring-retrieve-2-get-post"></a>
### POST /keyring/retrieve/2/get

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


<a name="keyring-retrieve-3-get-post"></a>
### POST /keyring/retrieve/3/get

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
|**200**|Successful response|[KeyringData](#keyringdata)|
|**400**|Something went wrong|No Content|


#### Produces

* `application/zip`



