package es.etg.dam;

import jakarta.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.CsrfValid;
import javax.mvc.binding.BindingResult;
import jakarta.validation.Valid;
import jakarta.validation.executable.ExecutableType;
import jakarta.validation.executable.ValidateOnExecution;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Controller
@Path("comments")
public class CommentController {
    @Inject
    Comments comments;
    @Inject
    BindingResult bindingResult;
    @Inject
    Models models;

    @GET
    public String show() {
        return "comments.jsp";
    }

    @POST
    @CsrfValid
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String post(@Valid @BeanParam CommentForm commentForm) {
        if (bindingResult.isFailed()) {
            models.put("bindingResult", bindingResult);
            return "comments.jsp";
        }
        comments.addComment(commentForm.getComment());
        return "redirect:/comments";
    }
}
