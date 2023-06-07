package com.red_velvet.flix.domain.utils

class UnAuthorizedException(msg: String) : Exception(msg)

class ServerException(msg: String) : Exception(msg)

class TimeOutException(msg: String) : Exception(msg)

class NotFoundException(msg: String) : Exception(msg)