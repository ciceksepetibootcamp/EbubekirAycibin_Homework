# Api Test With Rest Assured

Todo(add gift)

## Create New Repo in Github

#### Given
- Authorization Bearer Token
- Body { "name": "CreateTestRepo" }
#### When

- Post URL (https://api.github.com/user/repos )
#### Then

- Should Be Status Code 201

## Get List Created New Repo in Github

#### Given
- Authorization Bearer Token
#### When

- Get URL (https://api.github.com/user/repos )
- Body { "name": "CreateTestRepo" }

#### Then

- Should Be Status Code 200

## Delete Created New Repo in Github

#### Given
- Authorization Bearer Token
#### When

- Delete URL (https://api.github.com/repos/bekiraycibin/CreateTestRepo )
#### Then

- Should Be Status Code 204
