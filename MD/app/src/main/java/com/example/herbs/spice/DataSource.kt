package com.example.herbs.spice

import com.example.herbs.R

object DataSource {
    var spices: ArrayList<Spice> = generateDummySpices()

    private fun generateDummySpices(): ArrayList<Spice> {
        val spices: ArrayList<Spice> = ArrayList()
        spices.add(
            Spice(
                "Jahe",
                "Umbi Umbian",
                "Manfaat :\n" +
                        "1. Membantu Pencernaan: Jahe dapat meredakan gangguan pencernaan seperti mual dan muntah.\n" +
                        "2. Anti-inflamasi: Memiliki sifat anti-inflamasi yang dapat membantu mengurangi peradangan pada tubuh.\n" +
                        "3. Meningkatkan Imunitas: Jahe mengandung antioksidan yang dapat membantu meningkatkan sistem kekebalan tubuh.\n" +
                        "4. Mengurangi Rasa Sakit: Dikenal memiliki sifat analgesik yang dapat membantu meredakan nyeri tubuh.\n" +
                        "5. Menyegarkan Napas: Jahe juga digunakan untuk menyegarkan napas dan meredakan gangguan pernapasan seperti batuk.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rendang: Masakan khas Minangkabau dari Sumatera Barat yang menggunakan jahe dalam bumbunya.\n" +
                        "2. Ayam Penyet: Masakan Jawa Timur yang juga menggunakan jahe sebagai salah satu bumbunya.\n" +
                        "3. Soto Ayam: Sup ayam khas Indonesia yang umumnya mengandung jahe dalam kuahnya.\n" +
                        "4. Ayam Goreng Bumbu Kunyit: Masakan khas dari Bali yang menggunakan jahe dan kunyit sebagai bumbu utama.\n" +
                        "5. Sayur Lodeh: Masakan sayur khas Jawa yang kuahnya biasanya mengandung jahe untuk memberikan rasa hangat.",
                R.drawable.detail_jahe, R.drawable.item_jahe
            )
        )
        spices.add(
            Spice(
                "Lengkuas",
                "Umbi Umbian",
                "Manfaat :\n" +
                        "1. Aroma Harum: Lengkuas memberikan aroma yang khas dan harum pada masakan, membuatnya menjadi bumbu yang dicari untuk menyempurnakan hidangan.\n" +
                        "2. Rasa Pedas Sedang: Lengkuas memiliki rasa pedas yang lebih ringan daripada jahe, sehingga cocok digunakan dalam berbagai jenis masakan.\n" +
                        "3. Mengandung Zat Antioksidan: Seperti banyak rempah-rempah lainnya, lengkuas juga mengandung zat antioksidan yang baik untuk kesehatan tubuh.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rendang - Masakan khas Minangkabau dari Sumatera Barat yang menggunakan lengkuas sebagai salah satu bumbu utamanya.\n" +
                        "2. Sayur Lodeh - Masakan sayur khas Jawa yang sering menggunakan lengkuas untuk memberikan aroma dan rasa khas pada kuahnya.\n" +
                        "3. Soto Ayam - Sup ayam khas Indonesia yang umumnya mengandung lengkuas dalam kuahnya untuk meningkatkan rasa dan aroma.\n" +
                        "4. Ayam Goreng Bumbu Rujak - Masakan ayam goreng dengan bumbu rujak yang khas dari Jawa Tengah dan Jawa Timur, yang menggunakan lengkuas sebagai salah satu bumbu utamanya.\n" +
                        "5.Pepes Ikan - Masakan ikan yang dibungkus dengan daun pisang dan dipanggang atau dikukus, khas dari Jawa Barat, yang juga menggunakan lengkuas untuk memberikan rasa dan aroma.",

                R.drawable.detail_lengkuas,
                R.drawable.item_lengkuas
            )
        )
        spices.add(
            Spice(
                "Daun Salam",
                "Daun",
                "Manfaat:\n" +
                        "1. Aroma Harum: Daun salam memberikan aroma yang harum dan khas pada masakan, memberikan sentuhan yang mendalam pada hidangan.\n" +
                        "2. Membantu Pencernaan: Beberapa orang menggunakan daun salam untuk meredakan gangguan pencernaan seperti perut kembung.\n" +
                        "3. Antioksidan: Meskipun tidak banyak diteliti, daun salam juga diyakini memiliki kandungan antioksidan yang bermanfaat untuk kesehatan.\n" +
                        "4. Penyedap Alami: Daun salam sering digunakan sebagai penyedap alami untuk memperkaya rasa hidangan.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rendang - Masakan khas Minangkabau dari Sumatera Barat yang menggunakan daun salam sebagai salah satu bumbunya.\n" +
                        "2. Semur - Masakan daging yang direbus dengan bumbu-bumbu kaya, seperti daun salam, khas dari Indonesia.\n" +
                        "3. Sayur Lodeh - Masakan sayur khas Jawa yang menggunakan daun salam untuk memberikan aroma khas dalam kuahnya.\n" +
                        "4. Soto Ayam - Sup ayam khas Indonesia yang umumnya mengandung daun salam sebagai salah satu bumbunya.\n" +
                        "5. Ayam Goreng Bumbu Rujak - Masakan ayam goreng dengan bumbu yang menggunakan daun salam untuk memberikan aroma dan rasa khas.",
                R.drawable.detail_daunsalam,
                R.drawable.item_daunsalam
            )
        )
        spices.add(
            Spice(
                "Daun Jeruk",
                "Daun",
                "Manfaat:\n" +
                        "1. Aroma Segar: Daun jeruk memberikan aroma segar yang khas pada masakan, membuatnya lebih menarik dan lezat.\n" +
                        "2. Citrusy: Rasa citrus dari daun jeruk dapat menambahkan dimensi rasa baru pada masakan, mengimbangi rasa gurih atau pedas.\n" +
                        "3. Pembantu Pencernaan: Beberapa tradisi menyatakan bahwa daun jeruk dapat membantu sistem pencernaan.\n" +

                        "\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Ayam Rica-Rica: Masakan dari Manado yang pedas dan segar, menggunakan daun jeruk untuk memberikan aroma dan rasa khas.\n" +
                        "2. Gulai: Gulai Padang atau masakan kari yang menggunakan daun jeruk sebagai salah satu bahan untuk meningkatkan rasa.\n" +
                        "3. Soto: Sup tradisional Indonesia yang sering menggunakan daun jeruk untuk memberikan aroma segar pada kuahnya.\n" +
                        "4. Ikan Bakar: Ikan bakar dari berbagai daerah di Indonesia sering dimasak dengan menggunakan daun jeruk untuk memberikan aroma segar.\n",
                R.drawable.detail_daunjeruk,
                R.drawable.item_daunjeruk
            )
        )
        spices.add(
            Spice(
                "Ketumbar",
                "Biji",
                "Manfaat : \n" +
                        "1. Aroma Harum: Ketumbar memberikan aroma yang harum dan menyegarkan pada masakan, membantu meningkatkan cita rasa hidangan.\n" +
                        "2. Rasa Khas: Rasa ketumbar dapat memberikan sentuhan ringan manis dan pedas yang mendukung berbagai jenis masakan.\n" +
                        "3. Pencernaan: Beberapa studi menunjukkan bahwa ketumbar dapat membantu mempromosikan kesehatan pencernaan dan mengurangi gangguan pencernaan ringan.\n" +
                        "4. Anti-inflamasi: Ketumbar juga diketahui memiliki sifat anti-inflamasi yang dapat membantu meredakan peradangan dalam tubuh.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rawon: Masakan khas Jawa Timur berupa sup daging yang menggunakan ketumbar dalam bumbunya untuk memberikan aroma khas.\n" +
                        "2. Soto Ayam: Sup ayam khas Indonesia yang hampir selalu menggunakan ketumbar sebagai bumbu utama.\n" +
                        "3. Gulai: Berbagai jenis gulai di Indonesia, seperti gulai ayam atau gulai kambing, sering menggunakan ketumbar dalam bumbunya.\n" +
                        "4. Bumbu Rendang: Bumbu yang digunakan untuk membuat rendang, masakan Minangkabau yang kaya rempah, juga mengandung ketumbar sebagai salah satu bahan penting.",
                R.drawable.detail_ketumbar,
                R.drawable.item_ketumbar
            )
        )
        spices.add(
            Spice(
                "Kencur",
                "Umbi Umbian",
                "Manfaat:\n" +
                        "1. Mengatasi Gangguan Pencernaan: Kencur digunakan untuk meredakan gangguan pencernaan seperti perut kembung dan masuk angin.\n" +
                        "2. Anti-inflamasi: Memiliki sifat anti-inflamasi yang membantu meredakan peradangan pada tubuh.\n" +
                        "3. Menyegarkan Napas: Kencur sering digunakan dalam jamu atau minuman untuk menyegarkan napas dan menghilangkan bau mulut.\n" +
                        "4. Meningkatkan Nafsu Makan: Beberapa orang menggunakan kencur untuk meningkatkan nafsu makan.\n" +
                        "5. Meningkatkan Kesehatan Pencernaan: Kencur dapat membantu meningkatkan kesehatan pencernaan dengan merangsang produksi empedu.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rujak - Salah satu jenis rujak, seperti rujak cingur atau rujak buah, sering menggunakan kencur dalam bumbunya.\n" +
                        "2. Soto Ayam Lamongan - Soto ayam khas Lamongan, Jawa Timur, sering menggunakan kencur untuk memberikan aroma dan rasa khas.\n" +
                        "3. Jamu - Minuman tradisional Indonesia, seperti jamu kunyit asam, sering menggunakan kencur sebagai salah satu bahan utamanya.\n" +
                        "4. Sayur Lodeh - Masakan sayur khas Jawa yang kadang-kadang menggunakan kencur sebagai bumbu tambahan untuk memberikan rasa segar.",
                R.drawable.detail_kencur,
                R.drawable.item_kencur
            )
        )
        spices.add(
            Spice(
                "Cengkeh",
                "Bunga",
                "Manfaat:\n" +
                        "1.Aroma Kuat: Cengkeh memberikan aroma yang khas dan kuat pada masakan, terutama dalam kari, bir, dan minuman tradisional seperti wedang jahe.\n" +
                        "2. Sifat Antimikroba: Cengkeh memiliki sifat antimikroba dan antijamur yang dapat membantu menjaga makanan tetap segar dan bebas dari bakteri.\n" +
                        "3. Mengurangi Nyeri: Minyak cengkeh sering digunakan dalam pengobatan tradisional untuk mengurangi rasa sakit gigi dan nyeri otot.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rendang - Masakan khas Minangkabau dari Sumatera Barat yang menggunakan cengkeh dalam bumbunya untuk memberikan aroma kaya.\n" +
                        "2. Rawon - Sup daging khas Jawa Timur yang menggunakan cengkeh sebagai salah satu bumbu utama.\n" +
                        "3. Opor Ayam - Masakan ayam dengan kuah santan khas Jawa Tengah yang menggunakan cengkeh untuk menambah aroma dan rasa.\n",

                R.drawable.detail_cengkeh,
                R.drawable.item_cengkeh
            )
        )
        spices.add(
            Spice(
                "Kayu Manis",
                "Batang",
                "Manfaat :\n" +
                        "1. Penyedap Rasa: Kayu manis digunakan untuk memberikan aroma dan rasa manis yang khas pada berbagai jenis masakan dan minuman.\n" +
                        "2. Manfaat Kesehatan: Memiliki sifat antioksidan dan anti-inflamasi yang dapat membantu dalam menjaga kesehatan tubuh.\n" +
                        "3. Menyegarkan Napas: Kayu manis sering digunakan dalam minuman tradisional atau teh untuk menyegarkan napas dan membantu pencernaan.\n" +
                        "4. Pengatur Gula Darah: Beberapa penelitian menunjukkan bahwa konsumsi kayu manis dapat membantu mengatur kadar gula darah dalam tubuh.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Bubur Sumsum - Bubur tradisional Indonesia yang menggunakan kayu manis sebagai salah satu bumbunya.\n" +
                        "2. Rendang - Masakan Minangkabau dari Sumatera Barat yang kadang-kadang menggunakan kayu manis dalam bumbunya untuk memberikan aroma khas.\n" +
                        "3. Opor Ayam - Opor ayam khas Jawa Tengah yang sering menggunakan kayu manis dalam kuah santannya.\n" +
                        "4. Bubur Ketan Hitam - Bubur tradisional dari ketan hitam yang diberi aroma kayu manis.",
                R.drawable.detail_kayumanis,
                R.drawable.item_kayumanis
            )
        )
        spices.add(
            Spice(
                "Andaliman",
                "Buah",
                "Manfaat :\n" +
                        "1. Aroma Khas: Andaliman memberikan aroma yang segar dan unik pada masakan, membuatnya menjadi bumbu yang dicari untuk menyempurnakan hidangan.\n" +
                        "2. Rasa Pedas Ringan: Meskipun pedas, rasa andaliman tidak terlalu menyengat sehingga cocok untuk berbagai jenis masakan.\n" +
                        "3. Efek Kesegaran: Andaliman memberikan efek kesegaran pada lidah yang membuatnya menjadi bumbu yang disukai untuk hidangan berkuah atau yang berlemak.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Arsik - Hidangan ikan masak Batak yang menggunakan andaliman sebagai salah satu bumbu utamanya.\n" +
                        "2. Sambal Tuktuk - Sambal khas Tapanuli yang menggunakan andaliman untuk memberikan rasa dan aroma khas.\n" +
                        "3. Saksang - Hidangan Batak dari daging babi atau kambing yang menggunakan andaliman untuk menambahkan rasa dan aroma yang khas.\n" +
                        "4. Naniura - Hidangan daging ikan mentah khas Batak yang menggunakan andaliman sebagai bumbu utama.",
                R.drawable.detail_andaliman,
                R.drawable.item_andaliman
            )
        )
        spices.add(
            Spice(
                "Kemiri",
                "Biji",
                "Manfaat:\n" +
                        "1. Memberikan Tekstur dan Rasa Khas: Kemiri sering digunakan sebagai pengental dan pengental dalam bumbu masakan. Ini memberikan tekstur krimi serta rasa khas pada masakan.\n" +
                        "2. Menghasilkan Aroma Hangat: Minyak yang dihasilkan oleh kemiri memberikan aroma yang khas, yang memberikan karakteristik unik pada masakan.\n" +
                        "3. Kaya Akan Nutrisi: Kemiri mengandung nutrisi penting seperti lemak sehat, serat, dan vitamin B kompleks.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rendang - Masakan khas Minangkabau dari Sumatera Barat yang menggunakan kemiri sebagai salah satu bumbu dalam rempahnya.\n" +
                        "2. Opor Ayam - Masakan ayam yang dimasak dalam santan dengan bumbu rempah, termasuk kemiri untuk memberikan rasa dan tekstur yang khas.\n" +
                        "3. Semur - Masakan daging yang dimasak dalam bumbu manis, yang menggunakan kemiri sebagai bahan utama untuk memberikan rasa dan aroma yang lezat.\n" +
                        "4. Gule - Masakan kari kambing atau daging yang menggunakan kemiri sebagai bumbu utama untuk menambahkan kaya rasa dan tekstur krimi pada kuahnya.",
                R.drawable.detail_kemiri,
                R.drawable.item_kemiri
            )
        )
        spices.add(
            Spice(
                "Kunyit",
                "Umbi umbian",
                "Manfaat :\n" +
                        "1. Anti-inflamasi: Kunyit mengandung senyawa curcumin yang memiliki sifat anti-inflamasi dan dapat membantu meredakan peradangan dalam tubuh.\n" +
                        "2. Anti-oksidan: Senyawa dalam kunyit juga berperan sebagai anti-oksidan yang melindungi sel-sel tubuh dari kerusakan akibat radikal bebas.\n" +
                        "3. Meningkatkan Sistem Kekebalan Tubuh: Kunyit dapat meningkatkan sistem kekebalan tubuh dan membantu tubuh melawan infeksi.\n" +
                        "4. Membantu Pencernaan: Kunyit juga digunakan untuk merangsang produksi empedu yang membantu pencernaan makanan.\n" +
                        "5. Penggunaan Kosmetik: Kunyit sering digunakan dalam perawatan kulit tradisional untuk mencerahkan dan menghaluskan kulit.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rendang - Masakan khas Minangkabau dari Sumatera Barat yang menggunakan kunyit sebagai salah satu bumbu utama.\n" +
                        "2. Ayam Goreng Bumbu Kunyit - Masakan khas dari Bali yang menggunakan kunyit sebagai bumbu utama untuk ayam goreng.\n" +
                        "3. Gulai Kambing - Masakan kari kambing dengan bumbu rempah yang kaya, umumnya menggunakan kunyit sebagai salah satu bahan utamanya.\n" +
                        "4. Nasi Kuning - Hidangan nasi kuning khas Indonesia yang menggunakan kunyit untuk memberikan warna dan aroma khas.\n " +
                        "5. Jamu Kunyit Asam - Minuman jamu tradisional Indonesia yang menggunakan kunyit sebagai bahan utama untuk kesehatan dan kecantikan.",
                R.drawable.detail_kunyit,
                R.drawable.item_kunyit
            )
        )
        spices.add(
            Spice(
                "Pala",
                "Biji",
                "Manfaat:\n" +
                        "1. Aroma dan Rasa: Pala memberikan aroma hangat dan rasa yang khas pada masakan, membuatnya menjadi bumbu yang berharga dalam memperkaya cita rasa.\n" +
                        "2. Sifat Antiseptik: Pala memiliki sifat antiseptik alami yang bermanfaat untuk kesehatan saluran pencernaan.\n" +
                        "3. Stimulan Pencernaan: Pala dapat membantu meningkatkan pencernaan dan meredakan gangguan pencernaan ringan seperti perut kembung.\n" +
                        "4. Penggunaan dalam Obat-obatan: Pala juga digunakan dalam pengobatan tradisional untuk mengatasi masalah pernapasan dan penyakit kulit.\n" +
                        "\n" +
                        "Diolah menjadi :\n" +
                        "1. Rendang - Masakan Minangkabau yang menggunakan pala sebagai salah satu bumbu utamanya untuk memberikan aroma dan rasa khas.\n" +
                        "2.Opor Ayam - Masakan Jawa yang menggunakan pala dalam bumbunya, terutama yang berkuah santan.\n" +
                        "3. Lapis Legit - Kue lapis tradisional Indonesia yang menggunakan pala dalam adonannya untuk memberikan aroma dan rasa yang khas.",
                R.drawable.detail_pala,
                R.drawable.item_pala
            )
        )
        return spices
    }

}