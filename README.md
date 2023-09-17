# URLExtract
API to extract all entities and find relationships between these entities

## How to run this API?
To run this API:
- Clone the project
- Run the spring boot application by running URLExtractApplication class
- Once the project start, go to postman and make a new request
  - <strong>To get extracted text from a URL</strong>
    - Make a post request to `/extract-text`
    - set `url` in body
      ```
        {
          "url": "https://en.wikipedia.org/wiki/Java_(programming_language)"
        }
  - <strong>To get entities in extracted text</strong>
    - Make a post request to `/list-entities`
    - set `url` in body
      ```
        {
          "url": "https://en.wikipedia.org/wiki/Java_(programming_language)"
        }
  - <strong>To find relationships in entities extracted from the extracted text from a URL</strong>
    - Make a post request to `/find-relationships`
    - set `url` in body
      ```
        {
          "url": "https://en.wikipedia.org/wiki/Java_(programming_language)"
        }