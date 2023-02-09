package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType(Child.class)
                .allowIfSubType(GrandChild.class)
                .build();

        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

        Child child = new Child(1,2,"childField",33);
        GrandChild grandChild = new GrandChild(2,3,"childField22",44,true);

        String childString = mapper.writeValueAsString(child);
        String grandChildString = mapper.writeValueAsString(grandChild);

        System.out.println(childString);
        System.out.println(grandChildString);

        Parent parent1 = mapper.readValue(childString,Parent.class);
        parent1.setId(2);

        String parentString1 = mapper.writeValueAsString(parent1);
        System.out.println("From child: "+parentString1);

        Parent parent2 = mapper.readValue(grandChildString,Parent.class);
        parent1.setId(5);

        String parentString2 = mapper.writeValueAsString(parent2);
        System.out.println("From grandChild: "+parentString2);
    }
}
