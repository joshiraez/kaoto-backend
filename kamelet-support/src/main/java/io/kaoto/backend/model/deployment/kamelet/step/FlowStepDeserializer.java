package io.kaoto.backend.model.deployment.kamelet.step;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class FlowStepDeserializer extends JsonDeserializer {
    @Override
    public Object deserialize(final JsonParser jsonParser,
                            final DeserializationContext deserializationContext)
            throws IOException {
        JsonNode n = jsonParser.getCodec().readTree(jsonParser);

        if (n.get("choice") != null) {
            return new ObjectMapper().readValue(n.toPrettyString(),
                    ChoiceFlowStep.class);
        } else if (n.get("from") != null) {
            return new ObjectMapper().readValue(n.toPrettyString(),
                    From.class);
        } else if (n.get("set-body") != null) {
            return new ObjectMapper().readValue(n.toPrettyString(),
                    SetBodyFlowStep.class);
        } else if (n.get("set-header") != null) {
            return new ObjectMapper().readValue(n.toPrettyString(),
                    SetHeaderFlowStep.class);
        } else if (n.get("to") != null) {
            return new ObjectMapper().readValue(n.toPrettyString(),
                    ToFlowStep.class);
        } else if (n.get("uri") != null) {
            return new ObjectMapper().readValue(n.toPrettyString(),
                    UriFlowStep.class);
        }

        return null;
    }
}
