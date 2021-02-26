package com.sun.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.entity.Book;
import com.sun.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/book1")
    public List<Book> getBooks(){
        List<Book> list=bookMapper.findAll();
        return  list;
    }

    @GetMapping("/t")
    public Book getBookById(){
        return bookMapper.getBookById(1);
    }

    @GetMapping("/book/{page}/{size}")
    public PageInfo<Book> getEmp(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        List<Book> list=bookMapper.findAll();
        PageInfo<Book> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    @PostMapping("/save")
    public String insertBook(@RequestBody Book books){
        int res=bookMapper.insertBook(books);
        if(res>0){
            return "success";
        }else{
            return "false";
        }
    }
    @PutMapping("/update")
    public String udpBook(@RequestBody Book books){
        int res=bookMapper.updBook(books);
        if(res>0){
            return "success";
        }else{
            return "false";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public String delBook(@PathVariable int id){
        int res=bookMapper.delBookById(id);
        if(res>0){
            return "success";
        }else{
            return "false";
        }
    }
    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable int id){
        Book res=bookMapper.getBookById(id);
        return res;
    }
}
