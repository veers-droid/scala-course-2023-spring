package karazin.scala.users.group.week1.homework

import java.util.*
import kotlin.collections.List
import karazin.scala.users.group.week1.homework.adt.ErrorOr

object services {

    // We do not care about the implementation since we just want to build a structure of the application
    fun getUserProfile(): ErrorOr<model.UserProfile> = throw NotImplementedError()
    fun getPosts(userId: UUID): ErrorOr<List<model.Post>> = throw NotImplementedError()
    fun getComments(postId: UUID): ErrorOr<List<model.Comment>> = throw NotImplementedError()
    fun getLikes(postId: UUID): ErrorOr<List<model.Like>> = throw NotImplementedError()
    fun getShares(postId: UUID): ErrorOr<List<model.Share>> = throw NotImplementedError()
    
}