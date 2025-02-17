package io.kaoto.backend.model.deployment.kamelet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serial;

@JsonPropertyOrder({"constant", "simple"})
@JsonDeserialize(
        using = JsonDeserializer.None.class
)
public class Expression implements FlowStep {
    @Serial
    private static final long serialVersionUID = 7630089193555236497L;

    @JsonCreator
    public Expression(
            final @JsonProperty(value = "constant") String constant,
            final @JsonProperty(value = "simple") String simple) {
        super();
        setConstant(constant);
        setSimple(simple);
    }

    @JsonProperty("constant")
    private String constant;

    @JsonProperty("simple")
    private String simple;

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(final String constant) {
        this.constant = constant;
    }

    public String getSimple() {
        return simple;
    }

    public void setSimple(final String simple) {
        this.simple = simple;
    }
}
