# practitioner

A simple and quick way to track patients at a small clinic.

## Local set up
1. Install Leiningen as outlined [here](https://leiningen.org/) and Postgres [here](https://www.postgresql.org/docs/14/tutorial-install.html)  
2. Use `createdb practitioner` to create a new db. Create a new user with user name `dev` and password `password`
3. Connect to the db by using `psql practitioner -U dev -W`
4. Run the app locally by using `lein run`

## Usage

Use `lein run` to start.

### Test Coverage
Check test coverage by using `lein coverage`. Build will fail if the coverage is less than 75%

## Linting 

To lint the project run `lein clj-kondo`. This uses [lein-clj-kondo](https://github.com/clj-kondo/lein-clj-kondo) and is installed along with other dependencies/plugins 
in the project. Configure the linter in the project config 
in the `.clj-kondo/` directory 

## Developer Notes

Run tests using `lein test`

To start and stop server for development use `(mount/start)` and `(mount/stop)` respectively. Mount will setup the state including config and db datastore

Carry out a health check at `\api\ping`. A pong will be returned if everything is healthy

