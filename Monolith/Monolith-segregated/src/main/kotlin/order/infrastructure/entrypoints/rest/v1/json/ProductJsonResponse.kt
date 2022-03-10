package order.infrastructure.entrypoints.rest.v1.json

data class ProductJsonResponse (val id: String,
                                val description: String,
                                val price: Double,
                                val category: CategoryJsonResponse
)