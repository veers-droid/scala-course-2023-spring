package karazin.scala.users.group.week1.topic

import java.util.*
import kotlin.collections.List
import karazin.scala.users.group.week1.topic.adt.Option

object services {

    // We do not care about the implementation since we just want to build a structure of the application
    fun getUserProfile(): Option<model.UserProfile> = throw NotImplementedError()
    fun getPosts(userId: UUID): Option<List<model.Post>> = throw NotImplementedError()
    fun getComments(postId: UUID): Option<List<model.Comment>> = throw NotImplementedError()
    fun getLikes(postId: UUID): Option<List<model.Like>> = throw NotImplementedError()
    fun getShares(postId: UUID): Option<List<model.Share>> = throw NotImplementedError()
    
}