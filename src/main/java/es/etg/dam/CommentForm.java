package es.etg.dam;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;
import java.io.Serializable;

public class CommentForm implements Serializable {
    @NotNull
    @Size(min = 1, max = 10)
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @FormParam("comment")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
