package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should save a newly created account"
    request {
        method POST()
        url "/accounts"
        headers {
            contentType("application/json")
        }
        body([
                "ownerId": $(consumer(regex('\\d+'))),
                "accountCurrency": $(consumer(regex('\\d{3}'))),
                "accountAmount": $(consumer(regex('\\d+')))
        ])
    }
    response {
        status 201
        headers {
            header("Location", $(producer(regex('.+/accounts/\\d+'))))
        }
    }
}