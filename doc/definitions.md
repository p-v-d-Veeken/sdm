
<a name="definitions"></a>
## Definitions

<a name="client"></a>
### Client

|Name|Description|Schema|
|---|---|---|
|**created_at**  <br>*optional*|The creation date|string|
|**email**  <br>*required*|The email of the client|string|
|**fname**  <br>*required*|The first name of the client|string|
|**id**  <br>*optional*|The id of the client|integer|
|**lname**  <br>*required*|The last name of the client|string|
|**records**  <br>*optional*||< [Record](#record) > array|
|**updated_at**  <br>*optional*|The update date|string|


<a name="record"></a>
### Record

|Name|Description|Schema|
|---|---|---|
|**client_id**  <br>*optional*|The id of the concerning client|integer|
|**created_at**  <br>*optional*|The creation date|string|
|**id**  <br>*optional*|The id of the client|integer|
|**name**  <br>*required*|The name of the record|string|
|**updated_at**  <br>*optional*|The update date|string|
|**value**  <br>*required*|The value of the record|string|



