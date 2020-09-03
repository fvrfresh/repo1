package com.athome.domain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName CommentWrapper
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/25 9:17
 * @Version 1.0
 */
public class CommentWrapper {
    private CommentTransformed comment;
    private List<CommentTransformed> replies;

    public CommentWrapper() {
        this.comment = new CommentTransformed();
        this.replies = new LinkedList<CommentTransformed>();
    }

    public CommentTransformed getComment() {
        return comment;
    }

    public void setComment(CommentTransformed comment) {
        this.comment = comment;
    }

    public List<CommentTransformed> getReplies() {
        return replies;
    }

    public void addReply(CommentTransformed comment){
        this.replies.add(comment);
    }

    public void addAll(Collection<CommentTransformed> commentTransformeds){
        this.replies.addAll(commentTransformeds);
    }
}
