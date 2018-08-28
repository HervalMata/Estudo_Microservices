package com.herval.microservices.resources;

import com.herval.microservices.domain.model.entity.Entity;
import com.herval.microservices.domain.model.entity.User;
import com.herval.microservices.domain.service.UserService;
import com.herval.microservices.domain.valueobject.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    protected static final Logger logger = Logger.getLogger(UserController.class.getName());

    protected UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> findByName(@RequestParam("name") String name){
        logger.info(String.format("user-service findByName() invoked:{} for {} ", userService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<User> users;
        try {
            users = userService.findByNsme(name);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised findByName REST Call", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return users.size() > 0 ? new  ResponseEntity<>(users, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Entity> findById(@PathVariable("id") String id){
        logger.info(String.format("user-service findById() invoked:{} for {} ", userService.getClass().getName(), id));
        id = id.trim().toLowerCase();
        Entity user;
        try {
            user = userService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findById REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return user != null ? new  ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Entity> add(@RequestBody UserVO userVO){
        logger.info(String.format("user-service add() invoked:%s for %s ", userService.getClass().getName(), userVO.getName()));
        System.out.println(userVO);
        User user = new User(null, null, null, null, null);
        BeanUtils.copyProperties(userVO, user);
        try {
            userService.add(user);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised add Booking REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new  ResponseEntity<>(HttpStatus.CREATED);
    }
}
