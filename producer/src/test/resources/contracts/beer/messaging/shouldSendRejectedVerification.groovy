package contracts.beer.messaging

org.springframework.cloud.contract.spec.Contract.make {
    description ("""
Sends a negative verification message when person is eligible to get the beer
```
given:
    client is old enough
when:
    he applies for beer
then:
    we'll send a message with a false verification
```
""")
    // label which output message will be triggered
    label 'rejected_verification'
    outputMessage {
        // destination to which the output message will be sent
        sentTo 'verifications'
        // the body
        body([
                eligible: false
        ])
    }
}