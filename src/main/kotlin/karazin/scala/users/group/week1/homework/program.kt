package karazin.scala.users.group.week1.homework

import karazin.scala.users.group.week1.homework.adt.ErrorOr
import karazin.scala.users.group.week1.homework.model.PostView

object program {

    fun getPostsViews(): ErrorOr<List<ErrorOr<PostView>>> = throw NotImplementedError()
    fun getPostView(post: model.Post): ErrorOr<PostView> = throw NotImplementedError()

}