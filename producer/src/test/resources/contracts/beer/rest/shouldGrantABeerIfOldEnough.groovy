package contracts.beer.rest

org.springframework.cloud.contract.spec.Contract.make {
    request {
        description("""
Represents a successful scenario of getting a beer

given:
    Person is old enough
when:
    he ask for beer
then:
    should grant him the beer
""")
        method 'POST'
        url '/check'
        body(
                [
                        name: "foo",
                        age: 22
                ]
        )
        headers {
            header 'Content-Type', 'application/json'
        }
    }
    response {
        status 200
        body("""
            { "status" : "OK" }
        """)
        headers {
            header(
                    'Content-Type', value(consumer('application/json'), producer(regex('application/json.*')))
            )
        }
    }
}
