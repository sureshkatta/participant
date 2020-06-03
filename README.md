# participant
Tomcat on http://localhost:8081/

H2 embedded on http://localhost:8081/h2
Data is saved to C:/Work/H2data/participantDB

<B>Functional Definition</B><BR/>
Any participant header table will only compose details that do not need to be normalized. A participantType field will identify whether a participant needs further details - for instance: InquiryMember, Member, Provider, Employer, Business </BR>

A participant can have 0 or many of: <BR/>
    - Phone Number (type: Home, Cell, etc), <BR/>
    - Address (type: Home, Mailing, etc), <BR/>
     - Alias (), <BR/>
     - AlternateID (type: SSN, DL, ..) <BR/>
     - ParticipantStatus (statusCode: Active, Merged, Inactive) <BR/>
     - Relationship <BR/>

Each of the above, shall have a startDate and endDate fields, plus preferredInd (except ParticipantStatus). <BR/>

<B>Search Function</B> <BR/>
- Have an active ind to search in ParticipantStatus for currently Active. 
- Two sets of fields: Required and Non-Required

<B>Implment Pageable for all records </B>
