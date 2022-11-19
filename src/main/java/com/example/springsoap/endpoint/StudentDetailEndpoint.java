package com.example.springsoap.endpoint;


import com.example.students.AddStudentDetailsRequest;
import com.example.students.AddStudentDetailsResponse;
import com.example.students.GetStudentDetailsRequest;
import com.example.students.GetStudentDetailsResponse;
import com.example.students.StudentDetails;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentDetailEndpoint {

  private final static Map<Integer, StudentDetails> dataMap = new HashMap();

  @PayloadRoot(namespace = "http://example.com/students", localPart = "GetStudentDetailsRequest")
  @ResponsePayload
  public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {
    GetStudentDetailsResponse response = new GetStudentDetailsResponse();

    StudentDetails studentDetails = dataMap.get(request.getId());
    response.setStudentDetails(studentDetails);

    return response;
  }


  @PayloadRoot(namespace = "http://example.com/students", localPart = "AddStudentDetailsRequest")
  @ResponsePayload
  public AddStudentDetailsResponse addStudentDetails(@RequestPayload AddStudentDetailsRequest request) {
    AddStudentDetailsResponse response = new AddStudentDetailsResponse();

    StudentDetails studentDetails = new StudentDetails();
    studentDetails.setId(request.getStudentDetails().getId());
    studentDetails.setName(request.getStudentDetails().getName());
    studentDetails.setPassportNumber(request.getStudentDetails().getPassportNumber());

    dataMap.put(request.getStudentDetails().getId(), studentDetails);

    response.setStudentDetails(studentDetails);

    return response;
  }



}
