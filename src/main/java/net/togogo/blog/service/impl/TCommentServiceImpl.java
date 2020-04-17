package net.togogo.blog.service.impl;

import net.togogo.blog.entity.TComment;
import net.togogo.blog.mapper.TCommentMapper;
import net.togogo.blog.service.ITCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements ITCommentService {

}
