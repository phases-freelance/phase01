# phase01

1 POST a content /api/contents

RequestBody
 {
  "description" : "My Text"
 }
 
ResponseBody
 {
  "id" : 1,
  "description: "My Text"
 }
------------------------------------------------- 
2 Put a content /api/contents

RequestBody
 {
  "id" : 1,
  "description" : "My Text Update"
 }
 
ResponseBody
 {
  "id" : 1,
  "description: "My Text Update"
 }
 -------------------------------------------------
 3. Get a content /api/contents/1
 
 4. Find all contents /api/contents
 
 5 Delete a content /api/contents/1
 
