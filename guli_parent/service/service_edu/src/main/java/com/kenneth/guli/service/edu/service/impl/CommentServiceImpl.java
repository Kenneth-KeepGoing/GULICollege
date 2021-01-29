package com.kenneth.guli.service.edu.service.impl;

import com.kenneth.guli.service.edu.entity.Comment;
import com.kenneth.guli.service.edu.mapper.CommentMapper;
import com.kenneth.guli.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
