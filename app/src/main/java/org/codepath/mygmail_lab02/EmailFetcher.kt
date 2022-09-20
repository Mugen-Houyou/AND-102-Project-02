package org.codepath.mygmail_lab02

class EmailFetcher {
    companion object {
//        val senders = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
////        val title = "Welcome to Kotlin!"
////        val summary = "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin. Here are some tips to get started."
        val senders = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        val title = "Welcome to Kotlin!"
        val summary = "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin. Here are some tips to get started."

        fun getEmails(): MutableList<Email> {
            // EmailFetcher.getEmails() will return an initial list of 10 emails.
            var emails : MutableList<Email> = ArrayList()
//            for (i in 0..9) {
//                val email = Email(senders[i], title, summary)
//                emails.add(email)
//            }
            return emails;
        }

        fun getNext5Emails(): MutableList<Email> {
            // EmailFetcher.getNext5Emails() will return the next 5 emails if you are interested in implementing the stretch feature to let the user load more emails.
            var newEmails : MutableList<Email> = ArrayList()
            for (i in 10..14) {
                val email = Email(senders[i], title, summary)
                newEmails.add(email)
            }
            return newEmails
        }

        fun submitEmail(title: String, price: String, detail: String): MutableList<Email> {
            var newEmails : MutableList<Email> = ArrayList()
            val email = Email(title, price, detail)
            newEmails.add(email)
            return newEmails
        }
    }
}