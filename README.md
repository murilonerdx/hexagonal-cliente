
## Adapters In (Adaptadores de Entrada)

Função: Conectam fontes externas de dados ou gatilhos (como uma interface de usuário ou uma API) ao núcleo da aplicação. Eles 'traduzem' os dados de entrada em um formato que o núcleo da aplicação pode entender e processar.

Exemplo: Um controlador de API REST que recebe solicitações HTTP e as converte em chamadas aos casos de uso da aplicação.

## Adapters Out (Adaptadores de Saída)

Função: Conectam o núcleo da aplicação a serviços externos ou recursos de armazenamento (como bancos de dados, serviços de terceiros, etc.). Eles 'traduzem' as solicitações do núcleo da aplicação para o formato exigido por esses serviços externos.

Exemplo: Uma implementação de repositório que interage com um banco de dados SQL, convertendo as solicitações de domínio em consultas SQL.

## Application Core (Núcleo)

Função: Contém a lógica de negócios central e as entidades do domínio da aplicação. É onde as regras de negócio são definidas e processadas.
Exemplo: Classes de domínio representando entidades como 'Cliente' ou 'Pedido', com suas regras e relações de negócio.
Use Cases (Casos de Uso)


Função: Representam as operações específicas que podem ser realizadas dentro da aplicação, geralmente correspondendo a requisitos de negócio. Eles orquestram o fluxo de dados entre as entidades do domínio e os adaptadores.
Exemplo: Um caso de uso 'Criar Pedido' que recebe informações de pedido, valida-as, cria um registro de pedido no sistema e pode desencadear outras ações como notificações ou pagamentos.

## Ports In (Portas de Entrada)

Função: Interfaces através das quais os adaptadores de entrada interagem com o núcleo da aplicação. Eles definem como os dados externos podem entrar no sistema.
Exemplo: Uma interface de serviço de aplicativo que define métodos para criar um pedido, listar clientes, etc., que serão implementados pelos casos de uso.
Ports Out (Portas de Saída)

Função: Interfaces através das quais o núcleo da aplicação interage com os adaptadores de saída. Eles definem como a aplicação se comunica com recursos externos.
Exemplo: Uma interface de repositório que define métodos para salvar, atualizar ou buscar dados de entidades, que serão implementados pelos adaptadores de saída (como um repositório de banco de dados).s