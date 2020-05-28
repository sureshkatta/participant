# participant
Tomcat on http://localhost:8081/

H2 embedded on http://localhost:8081/h2
Data is saved to C:/Work/H2data/participantDB

#Functional Definition:
Any participant header table will only compose details that do not need to be normalized. A participantType field will identify whether a participant needs further details - for instance: InquiryMember, Member, Provider, Employer, Business

A participant can have 0 or many of: 
     Phone Number (type: Home, Cell, etc), 
     Address (type: Home, Mailing, etc), 
     Alias (), 
     AlternateID (type: SSN, DL, ..)
     ParticipantStatus (statusCode: Active, Merged, Inactive)
     Relationship

Each of the above, shall have a startDate and endDate fields, plus preferredInd (except ParticipantStatus). 

