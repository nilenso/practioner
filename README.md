# practitioner

A simple and quick way to track patients at a small clinic.

## Local set up
1. Have Leiningen and Postgres installed 
2. Use `createdb practitioner` to create a new db. Create a new user with user name `dev` and password `password`
3. Connect to the db by using `psql practitioner -U dev -W`
4. Run the app locally by using `lein run`
## Usage

FIXME: explanation

    $ java -jar practitioner-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Developer Notes

Run tests using `lein test`

To start and stop server for development use `(mount/start)` and `(mount/stop)` respectively. Mount will setup the state including config and db datastore

Carry out a health check at `\api\ping` . A pong will be returned if everything is healthy

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2022 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
