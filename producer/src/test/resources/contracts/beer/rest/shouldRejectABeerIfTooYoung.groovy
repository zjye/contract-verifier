package contracts.beer.rest

org.springframework.cloud.contract.spec.Contract.make {
    request {
        description("""
Represents a unsuccessful scenario of getting a beer

given:
    Person is too young
when:
    he ask for beer
then:
    should not grant him the beer
""")
        method 'POST'
        url '/check'
        body(
                [
                        name: "foo",
                        age: 19
                ]
        )
        headers {
            header 'Content-Type', 'application/json'
        }
    }
    response {
        status 200
        body("""
            { "status" : "NO_WAY" }
        """)
        headers {
            header(
                    'Content-Type', value(consumer('application/json'), producer(regex('application/json.*')))
            )
        }
    }
}
