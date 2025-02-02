package com.gottit.TCPProject.Controller;

import com.gottit.TCPProject.Model.Message;
import com.gottit.TCPProject.Service.DMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DMController {

    @Autowired
    private DMService dmService;

    @PostMapping("/DM/{to_id}")
    public ResponseEntity<Message> create(@RequestBody Message message, @PathVariable Long to_id){
        return new ResponseEntity<>(dmService.create(message, to_id), HttpStatus.CREATED);
    }

    @GetMapping("/[from_id]/{to_id}")
    public ResponseEntity<Iterable<Message>> showFromTo(@PathVariable Long from_id, @PathVariable Long to_id){
        return new ResponseEntity<>(dmService.show(from_id,to_id), HttpStatus.OK);
    }

}
