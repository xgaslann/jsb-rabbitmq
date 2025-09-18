# RabbitMQ Docker Image
```bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management
```
## Login to Management UI
- URL: http://localhost:15672
- User: guest
- Password: guest
- Port: 5672
- Management UI Port: 15672
## Enable Plugins
```bash
docker exec -it rabbitmq rabbitmq-plugins enable rabbitmq_stomp
docker exec -it rabbitmq rabbitmq-plugins enable rabbitmq_web_stomp
docker exec -it rabbitmq rabbitmq-plugins enable rabbitmq_federation
docker exec -it rabbitmq rabbitmq-plugins enable rabbitmq_federation_management
```
## Disable Plugins
```bash
docker exec -it rabbitmq rabbitmq-plugins disable rabbitmq_stomp
docker exec -it rabbitmq rabbitmq-plugins disable rabbitmq_web_stomp
docker exec -it rabbitmq rabbitmq-plugins disable rabbitmq_federation
docker exec -it rabbitmq rabbitmq-plugins disable rabbitmq_federation_management
```
## List Enabled Plugins
```bash
docker exec -it rabbitmq rabbitmq-plugins list
```
## Stop RabbitMQ Container
```bash
docker stop rabbitmq
```
## Remove RabbitMQ Container
```bash
docker rm rabbitmq
```
## View RabbitMQ Logs
```bash
docker logs rabbitmq
```
## Access RabbitMQ Container Shell
```bash
docker exec -it rabbitmq bash
```
## Change Default User Password
```bash
docker exec -it rabbitmq rabbitmqctl change_password guest newpassword
```
## Add New User
```bash
docker exec -it rabbitmq rabbitmqctl add_user newuser newpassword
docker exec -it rabbitmq rabbitmqctl set_user_tags newuser administrator
docker exec -it rabbitmq rabbitmqctl set_permissions -p / newuser ".*"
docker exec -it rabbitmq rabbitmqctl list_users
```
## Delete User
```bash
docker exec -it rabbitmq rabbitmqctl delete_user newuser
```
## List Queues
```bash
docker exec -it rabbitmq rabbitmqctl list_queues
```
## List Exchanges
```bash
docker exec -it rabbitmq rabbitmqctl list_exchanges
```
## List Connections
```bash
docker exec -it rabbitmq rabbitmqctl list_connections
```
## List Channels
```bash
docker exec -it rabbitmq rabbitmqctl list_channels
```
## List Virtual Hosts
```bash
docker exec -it rabbitmq rabbitmqctl list_vhosts
```
## List Policies
```bash
docker exec -it rabbitmq rabbitmqctl list_policies
```
## List Alarms
```bash
docker exec -it rabbitmq rabbitmqctl list_alarms
```
## Reset RabbitMQ Node
```bash
docker exec -it rabbitmq rabbitmqctl reset
```
## Stop RabbitMQ Application
```bash
docker exec -it rabbitmq rabbitmqctl stop_app
```
## Start RabbitMQ Application
```bash
docker exec -it rabbitmq rabbitmqctl start_app
```
## Force Reset RabbitMQ Node
```bash
docker exec -it rabbitmq rabbitmqctl force_reset
```
## Force Stop RabbitMQ Application
```bash
docker exec -it rabbitmq rabbitmqctl force_stop_app
```
## Check RabbitMQ Status
```bash
docker exec -it rabbitmq rabbitmqctl status
```
## Check RabbitMQ Version
```bash
docker exec -it rabbitmq rabbitmqctl version
```
## Check RabbitMQ Environment
```bash
docker exec -it rabbitmq rabbitmqctl environment
```
## Check RabbitMQ Cluster Status
```bash
docker exec -it rabbitmq rabbitmqctl cluster_status
```
## Join RabbitMQ Cluster
```bash
docker exec -it rabbitmq rabbitmqctl join_cluster rabbit@<node_name>
```
## Leave RabbitMQ Cluster
```bash
docker exec -it rabbitmq rabbitmqctl leave_cluster
```
## Reset RabbitMQ Cluster
```bash
docker exec -it rabbitmq rabbitmqctl reset
```
## Force Reset RabbitMQ Cluster
```bash
docker exec -it rabbitmq rabbitmqctl force_reset
```
## View RabbitMQ Configuration
```bash
docker exec -it rabbitmq cat /etc/rabbitmq/rabbitmq.conf
```
## Edit RabbitMQ Configuration
```bash
docker exec -it rabbitmq bash -c "echo 'loopback_users.guest = false' >> /etc/rabbitmq/rabbitmq.conf"
docker restart rabbitmq
```
## Persist Data
```bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -v rabbitmq_data:/var/lib/rabbitmq rabbitmq:4-management
```
## Backup RabbitMQ Data
```bash
docker exec -it rabbitmq rabbitmqctl export_definitions /var/lib/rabbitmq/backup.json
docker cp rabbitmq:/var/lib/rabbitmq/backup.json ./backup.json
```
## Restore RabbitMQ Data
```bash
docker cp ./backup.json rabbitmq:/var/lib/rabbitmq/backup.json
docker exec -it rabbitmq rabbitmqctl import_definitions /var/lib/rabbitmq/backup.json
```
## Update RabbitMQ Image
```bash
docker pull rabbitmq:4-management
docker stop rabbitmq
docker rm rabbitmq
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management
```
## Custom Configuration
- Create a custom configuration file `rabbitmq.conf` with your desired settings.
- Mount the configuration file to the container.
```bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -v /path/to/your/rabbitmq.conf:/etc/rabbitmq/rabbitmq.conf rabbitmq:4-management
```
## Environment Variables
- `RABBITMQ_DEFAULT_USER`: Set the default username (default: guest).
- `RABBITMQ_DEFAULT_PASS`: Set the default password (default: guest).
- `RABBITMQ_ERLANG_COOKIE`: Set the Erlang cookie for clustering (default: random).
```bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=myuser -e RABBITMQ_DEFAULT_PASS=mypassword rabbitmq:4-management
```
## Useful Links
- [Docker Hub RabbitMQ Image](https://hub.docker.com/_/rabbitmq)
- [RabbitMQ Documentation](https://www.rabbitmq.com/documentation.html)
- [RabbitMQ Tutorials](https://www.rabbitmq.com/getstarted.html)
- [RabbitMQ Official Website](https://www.rabbitmq.com/)
- [RabbitMQ Docker Hub](https://hub.docker.com/_/rabbitmq)
- [RabbitMQ Management Plugin](https://www.rabbitmq.com/management.html)
- [RabbitMQ CLI Tools](https://www.rabbitmq.com/cli.html)