package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return a list of accounts"
    request {
        method GET()
        url "/accounts"
    }
    response {
        status 200
        body([
                "page": [
                        "totalElements": $(producer(regex('\\d+'))),
                        "totalPages": $(producer(regex('\\d+'))),
                        "number": $(producer(regex('\\d+'))),
                        "size": $(producer(regex('\\d+')))
                ]
        ])
        headers {
            contentType('application/json')
        }
    }
}