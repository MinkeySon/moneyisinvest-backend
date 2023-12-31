package org.knulikelion.moneyisinvest.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.knulikelion.moneyisinvest.data.dto.request.CommentRequestDto;
import org.knulikelion.moneyisinvest.data.dto.request.CommentUpdateRequestDto;
import org.knulikelion.moneyisinvest.data.dto.request.ReplyCommentRequestDto;
import org.knulikelion.moneyisinvest.data.dto.response.BaseResponseDto;
import org.knulikelion.moneyisinvest.data.dto.response.CommentDetailResponseDto;
import org.knulikelion.moneyisinvest.data.dto.response.CommentResponseDto;
import org.knulikelion.moneyisinvest.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/community")
public class CommunityController {
    private final Logger LOGGER = LoggerFactory.getLogger(SignController.class);
    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급 받은 access_token", required = true, dataType = "String", paramType = "header")
    })
    @PostMapping("/post")
    public BaseResponseDto postComment(@RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        return communityService.postComment(commentRequestDto, request.getHeader("X-AUTH-TOKEN"));
    }

    @GetMapping("/get")
    public List<CommentResponseDto> getAllCommentByStockId(String stockId) {
        return communityService.getAllCommentByStockId(stockId);
    }

    @GetMapping("/get/detail")
    public List<CommentDetailResponseDto> getAllCommentByStockIdContainsAllReply(String stockId) {
        return communityService.getAllCommentByStockIdContainsAllReply(stockId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급 받은 access_token", required = true, dataType = "String", paramType = "header")
    })
    @DeleteMapping("/remove")
    public BaseResponseDto removeCommentById(Long id) {
        return communityService.removeComment(id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급 받은 access_token", required = true, dataType = "String", paramType = "header")
    })
    @PutMapping("/update")
    public BaseResponseDto updateCommentById(@RequestBody CommentUpdateRequestDto commentUpdateRequestDto) {
        return communityService.updateComment(commentUpdateRequestDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급 받은 access_token", required = true, dataType = "String", paramType = "header")
    })
    @PostMapping("/reply")
    public BaseResponseDto replyComment(@RequestBody ReplyCommentRequestDto replyCommentRequestDto, HttpServletRequest request) {
        return communityService.replyComment(replyCommentRequestDto, request.getHeader("X-AUTH-TOKEN"));
    }
}
