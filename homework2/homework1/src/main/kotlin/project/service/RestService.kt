package project.service

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RestService {
    @RequestMapping(method = [RequestMethod.GET], value = ["/health"], produces = ["application/json"])
    fun getHealth(): ResponseEntity<Status>{
        return ResponseEntity.ok(Status())
    }
}