from locust import HttpUser, task, between

class ContaUser(HttpUser):
    wait_time = between(1, 3)

    token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsZWFuZHJvQGdtYWlsLmNvbSIsImlhdCI6MTc0OTQ4NzQxNCwiZXhwIjoxNzUzMDg3NDE0fQ.Zg5M6Wk8tifD5TljreyiHGtop_1N-z9QAyGEy8zD_VzovHQWGjo6jS15vFWAkvyZSufL-0TFJQe5V4iuYe-SGg"

    def get_headers(self):
        return {
            "Authorization": f"Bearer {self.token}",
            "Content-Type": "application/json",
        }

    @task(1)
    def listar_contas(self):
        self.client.get("/contas", headers=self.get_headers())

    @task(1)
    def cadastrar_conta(self):
        payload = {
            "numero": "12345678",
            "agencia": "1234",
            "tipo": "CORRENTE",
            "saldo": 1000.00,
            "status": "ATIVO",
            "usuarioId": 1
        }
        self.client.post("/contas", json=payload, headers=self.get_headers())

    @task(1)
    def listar_conta_por_id(self):
        self.client.get("/contas/1", headers=self.get_headers())

    @task(1)
    def atualizar_conta(self):
        payload = {
            "numero": "12345678",
            "agencia": "1234",
            "tipo": "CORRENTE",
            "saldo": 1000.00,
            "status": "ATIVO",
            "usuarioId": 1
        }
        self.client.put("/contas/1", json=payload, headers=self.get_headers())

    @task(1)
    def deletar_conta(self):
        self.client.delete("/contas/1", headers=self.get_headers())
