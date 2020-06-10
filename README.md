# crawllink

This microservice implements an API for crawling links in a URL

#####To start the microservice:
* Go to the file: <i>'com.ex.crawllinks.rest.CrawllinksApplication'</i><br>
* Right-click anywhere on the source<br>
* Select <i>'Run MeetingsApplication.main'</i>

#####For the Simple API

<b>Method:</b> GET<br>
<b>URL:</b> /crawllinks<br>
<b>Params:</b><br>
URL<br>
crawlingDepth<br>

Example:<br>
GET<br>
`http://localhost:8080/crawllinks?URL=https://docs.oracle.com/en/&crawlingDepth=3`

#####For the Async AP

<b>Method:</b> GET<br>
<b>URL:</b> /crawllinks-improved<br>
<b>Params:</b><br>
URL<br>
crawlingDepth<br>

Example:<br>
GET<br>
`http://localhost:8080/crawllinks-imroved?URL=https://docs.oracle.com/en/&crawlingDepth=3`
