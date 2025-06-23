from locust import HttpUser, task, between

class UsuarioUser(HttpUser):
    wait_time = between(1, 3)

    token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsZWFuZHJvQGdtYWlsLmNvbSIsImlhdCI6MTc0OTQ4Nzk5MywiZXhwIjoxNzUzMDg3OTkzfQ.lHOOKhIvJiO6IWmSjuYu8l0ezJom1ZxHovlk8HsCHdhRz-YmK7_j26Nl4IG-Vu7Iip-I6f6f8kH2vxUviSF2zg"

    def get_headers(self):
        return {
            "Authorization": f"Bearer {self.token}",
            "Content-Type": "application/json",
        }

    @task(1)
    def listar_usuarios(self):
        self.client.get("/usuarios", headers=self.get_headers())

    @task(1)
    def cadastrar_usuario(self):
        payload = {
            "nome": "Raul Locust",
            "email": "raul.locust@example.com",
            "senha": "123456",
            "telefone": "123456789",
            "tipo": "tipo1",
            "ativo": True
        }
        self.client.post("/usuarios/cadastro", json=payload, headers=self.get_headers())

    @task(1)
    def listar_usuario_por_id(self):
        self.client.get("/usuarios/1", headers=self.get_headers())
