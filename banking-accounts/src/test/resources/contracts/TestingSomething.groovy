package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return a lit of accounts if asked"
    request {
        method GET()
        url("/accounts")
    }
    response {
        status 200
        body("{\n" +
                "  \"_embedded\" : {\n" +
                "    \"accounts\" : [ ]\n" +
                "  },\n" +
                "  \"_links\" : {\n" +
                "    \"self\" : {\n" +
                "      \"href\" : \"http://localhost/accounts{?page,size,sort}\",\n" +
                "      \"templated\" : true\n" +
                "    },\n" +
                "    \"profile\" : {\n" +
                "      \"href\" : \"http://localhost/profile/accounts\"\n" +
                "    },\n" +
                "    \"search\" : {\n" +
                "      \"href\" : \"http://localhost/accounts/search\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"page\" : {\n" +
                "    \"size\" : 20,\n" +
                "    \"totalElements\" : 0,\n" +
                "    \"totalPages\" : 0,\n" +
                "    \"number\" : 0\n" +
                "  }\n" +
                "}")
    }
}
